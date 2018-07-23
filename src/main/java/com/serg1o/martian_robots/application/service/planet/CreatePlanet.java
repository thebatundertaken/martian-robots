package com.serg1o.martian_robots.application.service.planet;

import com.serg1o.martian_robots.domain.model.Boundary;
import com.serg1o.martian_robots.domain.model.input.BoundaryInputParser;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.planet.PlanetFactory;

public class CreatePlanet {
    private final BoundaryInputParser boundaryInputParser;
    private final PlanetFactory planetFactory;

    public CreatePlanet(BoundaryInputParser boundaryInputParser, PlanetFactory planetFactory) {
        this.boundaryInputParser = boundaryInputParser;
        this.planetFactory = planetFactory;
    }

    public CreatePlanetResponse execute() {
        Boundary boundary = boundaryInputParser.parseInput();
        Planet planet = planetFactory.create(boundary);
        return new CreatePlanetResponse(planet);
    }
}
