package com.serg1o.martian_robots.infrastructure.robot.instruction;

import com.serg1o.martian_robots.domain.model.Degree;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;

public class TurnRight implements RobotInstruction {
    private final Robot robot;

    public TurnRight(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.turn(Degree.of(90));
    }
}
