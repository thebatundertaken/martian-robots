package com.serg1o.martian_robots.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DegreeTest {

    @Test
    public void convert_negative_integer_to_degree() {
        Degree degree = Degree.of(-90);

        assertEquals(degree.getDegree(), 270);
    }
}