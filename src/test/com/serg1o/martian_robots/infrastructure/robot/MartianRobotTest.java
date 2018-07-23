package com.serg1o.martian_robots.infrastructure.robot;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Degree;
import com.serg1o.martian_robots.domain.model.Distance;
import com.serg1o.martian_robots.domain.model.Orientation;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Enclosed.class)
public class MartianRobotTest {
    private static final String TEST_NAME = "TestRobot";

    public static class MartianRobotMoveTest {
        private Planet planetMock = mock(Planet.class);
        private Distance distance = new Distance(1);
        private RobotInfo robotInfo = RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH);
        private Robot robot = MartianRobot.of(TEST_NAME, robotInfo, planetMock);

        @Test
        public void move_within_boundaries() {
            when(planetMock.hasScent(any())).thenReturn(false);
            when(planetMock.withinBoundaries(any())).thenReturn(true);
            robot.move(distance);

            RobotInfo expected = RobotInfo.of(Coordinate.of(5, 11), Orientation.NORTH);
            assertEquals(robot.getInfo(), expected);
        }

        @Test
        public void not_move_if_scent_present() {
            when(planetMock.hasScent(any())).thenReturn(true);
            robot.move(distance);

            RobotInfo expected = robotInfo;
            assertEquals(robot.getInfo(), expected);
        }

        @Test(expected = OutOfTheGridException.class)
        public void throw_exception_when_leave_the_grid() {
            when(planetMock.hasScent(any())).thenReturn(false);
            when(planetMock.withinBoundaries(any())).thenReturn(false);
            robot.move(distance);

            verify(planetMock).leaveScent(any());
        }

        @Test
        public void leave_scent_when_leave_the_grid() {
            when(planetMock.hasScent(any())).thenReturn(false);
            when(planetMock.withinBoundaries(any())).thenReturn(false);
            try {
                robot.move(distance);
            }
            catch (OutOfTheGridException e) {
                verify(planetMock).leaveScent(any());
            }
        }
    }

    public static class MartianRobotTurnTest {
        @Mock
        private Planet planetMock;

        @Before
        public void beforeEachTest() {
            MockitoAnnotations.initMocks(this);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void turn_will_throw_exception_for_notsupported_degree() {
            Robot robot = MartianRobot.of(TEST_NAME, RobotInfo.of(Coordinate.of(0, 0), Orientation.NORTH), planetMock);
            robot.turn(Degree.of(45));
        }

    }

    @RunWith(Parameterized.class)
    public static class MartianRobotTurnParameterizedTest {
        @Mock
        private Planet planetMock;

        @Before
        public void beforeEachTest() {
            MockitoAnnotations.initMocks(this);
        }

        @Parameterized.Parameters
        public static Collection data() {
            return Arrays.asList(new Object[][]{
                    {
                            RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH),
                            Degree.of(90),
                            RobotInfo.of(Coordinate.of(5, 10), Orientation.EAST)
                    },
                    {
                            RobotInfo.of(Coordinate.of(5, 10), Orientation.NORTH),
                            Degree.of(270),
                            RobotInfo.of(Coordinate.of(5, 10), Orientation.WEST)
                    },
            });
        }

        @Parameterized.Parameter
        public RobotInfo input;

        @Parameterized.Parameter(1)
        public Degree degree;

        @Parameterized.Parameter(2)
        public RobotInfo expected;

        @Test
        public void test() {
            Robot robot = MartianRobot.of(TEST_NAME, input, planetMock);

            robot.turn(degree);

            assertEquals(robot.getInfo(), expected);
        }
    }

}