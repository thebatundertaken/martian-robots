package com.serg1o.martian_robots.application.service.mission;

import com.serg1o.martian_robots.domain.model.input.MissionInputParser;
import com.serg1o.martian_robots.domain.model.mission.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateMissionsTest {
    private static final int MAX_COORDINATE_VALUE = 50;
    
    @Mock
    private MissionInputParser mockMissionInputParser;
    @Mock
    private List<Mission> mockMissions;

    @Test
    public void create_planet_from_input() {
        CreateMissions service = new CreateMissions(mockMissionInputParser);
        CreateMissionsRequest request = new CreateMissionsRequest(MAX_COORDINATE_VALUE);

        when(mockMissionInputParser.parseInput(MAX_COORDINATE_VALUE)).thenReturn(mockMissions);
        CreateMissionsResponse response = service.execute(request);

        verify(mockMissionInputParser).parseInput(MAX_COORDINATE_VALUE);
        assertEquals(response.getMissions(), mockMissions);
    }
}