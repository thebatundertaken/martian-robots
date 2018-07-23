package com.serg1o.martian_robots.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private static final int INVALID_X = 70;
    private static final int VALID_X = 30;
    private static final int INVALID_Y = -5;
    private static final int VALID_Y = 20;

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_invalid_coordinate_x() {
        Coordinate.of(INVALID_X, VALID_Y);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_invalid_coordinate_y() {
        Coordinate.of(VALID_X, INVALID_Y);
    }

    @Test
    public void create_valid_instance_for_valid_coordinates() {
        Coordinate coordinate = Coordinate.of(VALID_X, VALID_Y);

        assertEquals(coordinate.getX(), VALID_X);
        assertEquals(coordinate.getY(), VALID_Y);
    }

    @Test
    public void print_coordinates_separated_by_whitespace() {
        Coordinate coordinate = Coordinate.of(VALID_X, VALID_Y);

        assertEquals(coordinate.toString(), VALID_X + " " + VALID_Y);
    }
}