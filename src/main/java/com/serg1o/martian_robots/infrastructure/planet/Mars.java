package com.serg1o.martian_robots.infrastructure.planet;

import com.serg1o.martian_robots.domain.model.Boundary;
import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.planet.Planet;

import java.util.HashSet;
import java.util.Set;

public class Mars implements Planet {
    private final Set<Coordinate> scents;
    private Boundary boundary;

    public Mars(Boundary boundary) {
        this.boundary = boundary;
        scents = new HashSet<>();
    }

    public boolean withinBoundaries(Coordinate coordinate) {
        return boundary.withinBoundaries(coordinate);
    }

    @Override
    public void leaveScent(Coordinate coordinate) {
        scents.add(coordinate);
    }

    @Override
    public boolean hasScent(Coordinate coordinate) {
        return scents.contains(coordinate);
    }
}
