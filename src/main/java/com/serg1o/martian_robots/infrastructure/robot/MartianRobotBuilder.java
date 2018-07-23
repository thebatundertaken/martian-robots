package com.serg1o.martian_robots.infrastructure.robot;

import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotBuilder;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;

import java.util.concurrent.atomic.AtomicInteger;

public class MartianRobotBuilder implements RobotBuilder {
    private final Planet planet;
    private AtomicInteger robotCounter;

    public MartianRobotBuilder(Planet planet) {
        if (planet == null) {
            throw new IllegalArgumentException("planet");
        }

        this.planet = planet;
        robotCounter = new AtomicInteger(0);
    }

    @Override
    public Robot build(RobotInfo info) {
        return MartianRobot.of(getRobotName(), info, planet);
    }

    private String getRobotName() {
        return "MarsRover" + robotCounter.incrementAndGet();
    }
}
