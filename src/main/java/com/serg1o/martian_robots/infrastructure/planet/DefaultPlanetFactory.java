package com.serg1o.martian_robots.infrastructure.planet;

import com.serg1o.martian_robots.domain.model.Boundary;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.planet.PlanetFactory;

public class DefaultPlanetFactory implements PlanetFactory {

    @Override
    public Planet create(Boundary boundary) {
        return new Mars(boundary);
    }
}
