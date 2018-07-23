package com.serg1o.martian_robots.infrastructure.input;

import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;
import com.serg1o.martian_robots.infrastructure.robot.instruction.MoveForward;
import com.serg1o.martian_robots.infrastructure.robot.instruction.TurnLeft;
import com.serg1o.martian_robots.infrastructure.robot.instruction.TurnRight;

import java.util.function.Function;

public class RobotInstructionParser implements Function<Character, RobotInstruction> {
    private final Robot robot;

    public RobotInstructionParser(Robot robot) {
        this.robot = robot;
    }

    @Override
    public RobotInstruction apply(Character character) {
        switch (character) {
            case 'L':
                return new TurnLeft(robot);

            case 'R':
                return new TurnRight(robot);

            case 'F':
                return new MoveForward(robot);

            default:
                throw new IllegalArgumentException("Invalid robot instruction " + String.valueOf(character));
        }
    }
}
