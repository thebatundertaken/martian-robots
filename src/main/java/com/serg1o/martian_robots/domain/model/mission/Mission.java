package com.serg1o.martian_robots.domain.model.mission;

import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInstruction;

import java.util.List;

public class Mission {
    private final Robot robot;
    private final List<RobotInstruction> robotInstructions;

    public Mission(Robot robot, List<RobotInstruction> robotInstructions) {
        this.robot = robot;
        this.robotInstructions = robotInstructions;
    }

    public Robot getRobot() {
        return robot;
    }

    public List<RobotInstruction> getRobotInstructions() {
        return robotInstructions;
    }
}
