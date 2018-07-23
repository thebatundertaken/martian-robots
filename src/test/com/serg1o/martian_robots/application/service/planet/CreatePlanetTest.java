package com.serg1o.martian_robots.application.service.planet;

import com.serg1o.martian_robots.domain.model.Boundary;
import com.serg1o.martian_robots.domain.model.input.BoundaryInputParser;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.domain.model.planet.PlanetFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreatePlanetTest {
    @Mock
    private BoundaryInputParser mockBoundaryInputParser;
    @Mock
    private PlanetFactory mockPlanetFactory;
    @Mock
    private Boundary mockBoundary;
    @Mock
    private Planet mockPlanet;

    @Test
    public void create_planet_from_input() {
        CreatePlanet service = new CreatePlanet(mockBoundaryInputParser, mockPlanetFactory);

        when(mockBoundaryInputParser.parseInput()).thenReturn(mockBoundary);
        when(mockPlanetFactory.create(mockBoundary)).thenReturn(mockPlanet);
        CreatePlanetResponse response = service.execute();

        verify(mockBoundaryInputParser).parseInput();
        verify(mockPlanetFactory).create(mockBoundary);
        assertEquals(response.getPlanet(), mockPlanet);
    }
}