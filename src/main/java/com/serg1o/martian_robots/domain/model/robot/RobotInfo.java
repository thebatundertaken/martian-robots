package com.serg1o.martian_robots.domain.model.robot;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Orientation;

import java.util.Objects;

public class RobotInfo {
    private final Coordinate coordinate;
    private final Orientation orientation;

    public static RobotInfo of(Coordinate coordinate, Orientation orientation) {
        if (coordinate == null) {
            throw new IllegalArgumentException("coordinate");
        }

        if (orientation == null) {
            throw new IllegalArgumentException("orientation");
        }

        return new RobotInfo(coordinate, orientation);
    }

    private RobotInfo(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RobotInfo robotInfo = (RobotInfo) o;
        return Objects.equals(coordinate, robotInfo.coordinate) &&
                orientation == robotInfo.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, orientation);
    }

    @Override
    public String toString() {
        return coordinate + " " + orientation;
    }
}
