package com.serg1o.martian_robots.domain.model.robot;

import com.serg1o.martian_robots.domain.model.Degree;
import com.serg1o.martian_robots.domain.model.Distance;
import com.serg1o.martian_robots.infrastructure.robot.OutOfTheGridException;

public interface Robot {

    public void turn(Degree degree);

    public void move(Distance distance) throws OutOfTheGridException;

    public RobotInfo getInfo();

    public String getName();
}
