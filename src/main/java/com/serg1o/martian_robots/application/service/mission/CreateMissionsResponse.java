package com.serg1o.martian_robots.application.service.mission;

import com.serg1o.martian_robots.domain.model.mission.Mission;

import java.util.List;

public class CreateMissionsResponse {
    private List<Mission> missions;

    public CreateMissionsResponse(List<Mission> missions) {
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
