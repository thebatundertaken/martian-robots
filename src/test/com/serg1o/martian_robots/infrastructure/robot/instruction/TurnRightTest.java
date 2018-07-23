package com.serg1o.martian_robots.infrastructure.robot.instruction;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Orientation;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;
import com.serg1o.martian_robots.infrastructure.robot.MartianRobot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TurnRightTest {
    private static final String TEST_NAME = "TestRobot";
    @Mock
    private Planet planetMock;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH),
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.EAST)
                },
                {
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.SOUTH),
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.WEST)
                },
                {
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.EAST),
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.SOUTH)
                },
                {
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.WEST),
                        RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH)
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
        TurnRight turnRight = new TurnRight(robot);

        turnRight.execute();

        assertEquals(robot.getInfo(), expected);
    }
}