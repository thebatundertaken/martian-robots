package com.serg1o.martian_robots.application.service.robot;

import com.serg1o.martian_robots.domain.model.mission.Mission;

import java.util.List;

public class RunRobotsRequest {
    private final List<Mission> missions;

    public RunRobotsRequest(List<Mission> missions) {
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
