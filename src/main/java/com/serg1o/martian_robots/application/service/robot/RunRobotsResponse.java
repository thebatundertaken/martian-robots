package com.serg1o.martian_robots.application.service.robot;

public class RunRobotsResponse {
    private final String output;

    public RunRobotsResponse(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
