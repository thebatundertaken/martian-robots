package com.serg1o.martian_robots.domain.model;

import java.util.Arrays;

public enum Orientation {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String orientation;

    Orientation(String orientation) {
        this.orientation = orientation;
    }

    public Orientation turnLeft() {
        switch (this) {
            case NORTH:
                return Orientation.WEST;
            case SOUTH:
                return Orientation.EAST;
            case EAST:
                return Orientation.NORTH;
            default:
                return Orientation.SOUTH;
        }
    }

    public Orientation turnRight() {
        switch (this) {
            case NORTH:
                return Orientation.EAST;
            case SOUTH:
                return Orientation.WEST;
            case EAST:
                return Orientation.SOUTH;
            default:
                return Orientation.NORTH;
        }
    }

    public static Orientation findByValue(final String string){
        return Arrays.stream(values())
                .filter(
                    value -> value.orientation.equals(string)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return orientation;
    }
}
