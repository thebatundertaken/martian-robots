package com.serg1o.martian_robots.domain.model.robot;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
 */
public interface RobotBuilder {

    public Robot build(RobotInfo info);
}
