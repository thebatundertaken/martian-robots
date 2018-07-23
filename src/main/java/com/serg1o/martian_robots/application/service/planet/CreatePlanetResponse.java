package com.serg1o.martian_robots.application.service.planet;

import com.serg1o.martian_robots.domain.model.planet.Planet;

public class CreatePlanetResponse {
    private final Planet planet;

    public CreatePlanetResponse(Planet planet) {
        this.planet = planet;
    }

    public Planet getPlanet() {
        return planet;
    }
}
