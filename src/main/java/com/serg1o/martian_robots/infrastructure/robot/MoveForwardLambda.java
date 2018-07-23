package com.serg1o.martian_robots.infrastructure.robot;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Distance;

@FunctionalInterface
public interface MoveForwardLambda {

    public Coordinate apply(Coordinate coordinate, Distance distance);
}
