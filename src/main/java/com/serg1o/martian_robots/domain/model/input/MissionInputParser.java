package com.serg1o.martian_robots.domain.model.input;

import com.serg1o.martian_robots.domain.model.mission.Mission;

import java.util.List;

public interface MissionInputParser {

    public List<Mission> parseInput(int maxCoordinateValue);
}
