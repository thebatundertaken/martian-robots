package com.serg1o.martian_robots.application.service.mission;

public class CreateMissionsRequest {
    private final int maxCoordinateValue;

    public CreateMissionsRequest(int maxCoordinateValue) {
        this.maxCoordinateValue = maxCoordinateValue;
    }

    public int getMaxCoordinateValue() {
        return maxCoordinateValue;
    }
}
