package com.serg1o.martian_robots.domain.model.planet;

import com.serg1o.martian_robots.domain.model.Coordinate;

public interface Planet {

    public boolean withinBoundaries(Coordinate coordinate);

    public void leaveScent(Coordinate coordinate);

    public boolean hasScent(Coordinate coordinate);
}
