package com.serg1o.martian_robots.domain.model;

import java.util.Objects;

public class Coordinate {
    private static final int MAX_X = 50;
    private static final int MAX_Y = 50;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private final int x;
    private final int y;

    public static Coordinate of(int x, int y) {
        if (x < MIN_X || x > MAX_X) {
            throw new IllegalArgumentException("x");
        }

        if (y < MIN_Y || y > MAX_Y) {
            throw new IllegalArgumentException("y");
        }

        return new Coordinate(x, y);
    }

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
