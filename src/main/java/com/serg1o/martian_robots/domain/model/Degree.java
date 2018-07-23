package com.serg1o.martian_robots.domain.model;

public class Degree {
    public static final int MAX_ANGLE = 360;
    private final int degree;

    public static Degree of(int degree) {
        degree = degree % MAX_ANGLE;
        if (degree < 0) {
            degree += MAX_ANGLE;
        }

        return new Degree(degree);
    }

    private Degree(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
}
