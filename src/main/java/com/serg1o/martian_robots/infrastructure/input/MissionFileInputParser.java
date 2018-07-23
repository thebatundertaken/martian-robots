package com.serg1o.martian_robots.infrastructure.input;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Orientation;
import com.serg1o.martian_robots.domain.model.input.MissionInputParser;
import com.serg1o.martian_robots.domain.model.mission.Mission;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotBuilder;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissionFileInputParser extends AbstractFileInputParser implements MissionInputParser {
    private final int maxLineLength;
    private final RobotBuilder robotBuilder;

    public MissionFileInputParser(int maxLineLength, String filename, RobotBuilder robotBuilder) {
        super(filename);
        this.maxLineLength = maxLineLength;
        this.robotBuilder = robotBuilder;
    }

    @Override
    public List<Mission> parseInput(int maxCoordinateValue) {
        return getMissions(getFileContent().skip(1));
    }

    private List<Mission> getMissions(Stream<String> stream) {
        List<Mission> missions = new ArrayList<>();
        boolean odd = true;
        RobotInfo robotInfo = null;

        Iterator<String> iterator = stream
                                        .sequential()
                                        .map(new FileLineSanitizer())
                                        .iterator();

        while (iterator.hasNext()) {
            String line = iterator.next();
            if (odd) {
                String[] split = line.split("\\s");
                if (split.length != 3) {
                    throw new IllegalArgumentException("Invalid coordinate+position line format");
                }

                robotInfo = RobotInfo.of(
                        Coordinate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1])),
                        Orientation.findByValue(split[2])
                );
                odd = false;
                continue;
            }

            Robot robot = robotBuilder.build(robotInfo);
            List<RobotInstruction> robotInstructions = line.chars()
                    .limit(maxLineLength)
                    .mapToObj(i -> (char)i)
                    .map(new RobotInstructionParser(robot))
                    .collect(Collectors.toList());

            missions.add(
                new Mission(robot, robotInstructions)
            );
            odd = true;
        }

        return missions;
    }
}
