package com.serg1o.martian_robots.infrastructure.robot.instruction;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Orientation;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;
import com.serg1o.martian_robots.infrastructure.robot.MartianRobot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class MoveForwardTest {
    private static final String TEST_NAME = "TestRobot";
    @Mock
    private Planet planetMock;

    @Before
    public void beforeEachTest() {
        MockitoAnnotations.initMocks(this);
        when(planetMock.hasScent(any())).thenReturn(false);
        when(planetMock.withinBoundaries(any())).thenReturn(true);
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {
                    RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH),
                    RobotInfo.of(Coordinate.of(5, 11), Orientation.NORTH)
                },
                {
                    RobotInfo.of(Coordinate.of(5, 10), Orientation.SOUTH),
                    RobotInfo.of(Coordinate.of(5, 9), Orientation.SOUTH)
                },
                {
                    RobotInfo.of(Coordinate.of(5, 10), Orientation.EAST),
                    RobotInfo.of(Coordinate.of(6, 10), Orientation.EAST)
                },
                {
                    RobotInfo.of(Coordinate.of(5, 10), Orientation.WEST),
                    RobotInfo.of(Coordinate.of(4, 10), Orientation.WEST)
                },
        });
    }

    @Parameterized.Parameter
    public RobotInfo input;

    @Parameterized.Parameter(1)
    public RobotInfo expected;

    @Test
    public void test() {
        Robot robot = MartianRobot.of(TEST_NAME, input, planetMock);
        MoveForward moveForward = new MoveForward(robot);

        moveForward.execute();

        assertEquals(robot.getInfo(), expected);
    }
}