package com.serg1o.martian_robots.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrientationTest {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                { Orientation.NORTH, Orientation.WEST, Orientation.EAST },
                { Orientation.SOUTH, Orientation.EAST , Orientation.WEST },
                { Orientation.EAST, Orientation.NORTH, Orientation.SOUTH },
                { Orientation.WEST, Orientation.SOUTH, Orientation.NORTH },
        });
    }

    @Parameterized.Parameter
    public Orientation input;

    @Parameterized.Parameter(1)
    public Orientation expectedLeft;

    @Parameterized.Parameter(2)
    public Orientation expectedRight;

    @Test
    public void turn_left_with_dataprovider() {
        assertEquals(expectedLeft, input.turnLeft());
    }

    @Test
    public void turn_right_with_dataprovider() {
        assertEquals(expectedRight, input.turnRight());
    }
}