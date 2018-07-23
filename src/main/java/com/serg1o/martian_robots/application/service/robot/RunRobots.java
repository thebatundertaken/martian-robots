package com.serg1o.martian_robots.application.service.robot;

import com.serg1o.martian_robots.domain.model.mission.Mission;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;
import com.serg1o.martian_robots.infrastructure.robot.OutOfTheGridException;

import java.util.List;

public class RunRobots {

    public RunRobotsResponse execute(RunRobotsRequest request) {
        List<Mission> missions = request.getMissions();
        StringBuilder builder = new StringBuilder();
        final String EOF = System.getProperty("line.separator");

        for (Mission mission : missions) {
            Robot robot = mission.getRobot();
            List<RobotInstruction> robotInstructions = mission.getRobotInstructions();

            builder.append(robot.getInfo());
            builder.append(EOF);

            try {
                for (RobotInstruction instruction : robotInstructions) {
                    instruction.execute();
                }
            }
            catch (OutOfTheGridException e) {
                builder.append(robot.getInfo());
                builder.append(" LOST");
                builder.append(EOF);
                continue;
            }

            builder.append(robot.getInfo());
            builder.append(EOF);
        }

        return new RunRobotsResponse(builder.toString());
    }
}
