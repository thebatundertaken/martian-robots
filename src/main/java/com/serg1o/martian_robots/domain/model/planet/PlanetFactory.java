package com.serg1o.martian_robots.domain.model.planet;

import com.serg1o.martian_robots.domain.model.Boundary;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory pattern</a>
 */
public interface PlanetFactory {

    public Planet create(Boundary boundary);
}
