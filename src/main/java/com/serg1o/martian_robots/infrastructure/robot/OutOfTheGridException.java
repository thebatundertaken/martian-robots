package com.serg1o.martian_robots.infrastructure.robot;

import com.serg1o.martian_robots.domain.model.Coordinate;

public class OutOfTheGridException extends RuntimeException {
    private final Coordinate coordinate;

    public OutOfTheGridException(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
