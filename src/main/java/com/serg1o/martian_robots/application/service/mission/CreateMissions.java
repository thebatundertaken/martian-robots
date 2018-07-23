package com.serg1o.martian_robots.application.service.mission;

import com.serg1o.martian_robots.domain.model.input.MissionInputParser;
import com.serg1o.martian_robots.domain.model.mission.Mission;

import java.util.List;

public class CreateMissions {
    private final MissionInputParser missionInputParser;

    public CreateMissions(MissionInputParser missionInputParser) {
        this.missionInputParser = missionInputParser;
    }

    public CreateMissionsResponse execute(CreateMissionsRequest request) {
        List<Mission> missions = missionInputParser.parseInput(request.getMaxCoordinateValue());
        return new CreateMissionsResponse(missions);
    }
}
