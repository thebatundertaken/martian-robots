package com.serg1o.martian_robots.domain.model;

public class Boundary {
    private final Coordinate min;
    private final Coordinate max;

    public Boundary(Coordinate min, Coordinate max) {
        this.min = min;
        this.max = max;
    }

    public boolean withinBoundaries(Coordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("coordinate");
        }

        return coordinate.getX() >= min.getX() &&
                coordinate.getY() >= min.getY() &&
                coordinate.getX() <= max.getX() &&
                coordinate.getY() <= max.getY();
    }
}
