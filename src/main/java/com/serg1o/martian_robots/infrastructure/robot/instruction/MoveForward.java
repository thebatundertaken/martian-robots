package com.serg1o.martian_robots.infrastructure.robot.instruction;

import com.serg1o.martian_robots.domain.model.Distance;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;
import com.serg1o.martian_robots.infrastructure.robot.OutOfTheGridException;

public class MoveForward implements RobotInstruction {
    private static final Distance DEFAULT_DISTANCE = new Distance(1);
    private final Robot robot;

    public MoveForward(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() throws OutOfTheGridException {
        robot.move(DEFAULT_DISTANCE);
    }
}
