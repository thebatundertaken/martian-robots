package com.serg1o.martian_robots.domain.model.robot;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Command_pattern">Command pattern</a>
 */
@FunctionalInterface
public interface RobotInstruction {

    public void execute();
}
