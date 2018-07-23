package com.serg1o.martian_robots.infrastructure.robot;

import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.Degree;
import com.serg1o.martian_robots.domain.model.Distance;
import com.serg1o.martian_robots.domain.model.Orientation;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.robot.Robot;
import com.serg1o.martian_robots.domain.model.robot.RobotInfo;

import java.util.HashMap;
import java.util.Map;

public class MartianRobot implements Robot {
    private static Map<Orientation, MoveForwardLambda> moveForwardLambdaMap = new HashMap<>();
    private final String name;
    private Coordinate coordinate;
    private Orientation orientation;
    private Planet planet;

    static {
        moveForwardLambdaMap.put(
                Orientation.NORTH,
                (Coordinate coordinate, Distance distance) -> Coordinate.of(coordinate.getX(), coordinate.getY() + distance.getDistance())
        );
        moveForwardLambdaMap.put(
                Orientation.SOUTH,
                (Coordinate coordinate, Distance distance) -> Coordinate.of(coordinate.getX(), coordinate.getY() - distance.getDistance())
        );
        moveForwardLambdaMap.put(
                Orientation.EAST,
                (Coordinate coordinate, Distance distance) -> Coordinate.of(coordinate.getX() + distance.getDistance(), coordinate.getY())
        );
        moveForwardLambdaMap.put(
                Orientation.WEST,
                (Coordinate coordinate, Distance distance) -> Coordinate.of(coordinate.getX() - distance.getDistance(), coordinate.getY())
        );
    }

    public static MartianRobot of(String name, RobotInfo info, Planet planet) {
        if (name == null) {
            throw new IllegalArgumentException("name");
        }

        if (info == null) {
            throw new IllegalArgumentException("info");
        }

        return new MartianRobot(name, info, planet);
    }

    private MartianRobot(String name, RobotInfo info, Planet planet) {
        this.name = name;
        this.coordinate = info.getCoordinate();
        this.orientation = info.getOrientation();
        this.planet = planet;
    }

    @Override
    public void turn(Degree degree) {
        switch (degree.getDegree()) {
            case 90:
                orientation = orientation.turnRight();
                break;

            case 270:
                orientation = orientation.turnLeft();
                break;

            default:
                throw new UnsupportedOperationException();
        }

    }

    @Override
    public void move(Distance distance) throws OutOfTheGridException {
        Coordinate newCoordinate = moveForwardLambdaMap.get(orientation).apply(coordinate, distance);
        if (planet.hasScent(newCoordinate)) {
            return;
        }

        if (!planet.withinBoundaries(newCoordinate)) {
            planet.leaveScent(newCoordinate);
            throw new OutOfTheGridException(newCoordinate);
        }

        coordinate = newCoordinate;
    }

    @Override
    public RobotInfo getInfo() {
        return RobotInfo.of(coordinate, orientation);
    }

    @Override
    public String getName() {
        return name;
    }
}
