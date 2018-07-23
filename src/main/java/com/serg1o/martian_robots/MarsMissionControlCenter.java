package com.serg1o.martian_robots;

import com.serg1o.martian_robots.application.service.mission.CreateMissions;
import com.serg1o.martian_robots.application.service.mission.CreateMissionsRequest;
import com.serg1o.martian_robots.application.service.mission.CreateMissionsResponse;
import com.serg1o.martian_robots.application.service.planet.CreatePlanet;
import com.serg1o.martian_robots.application.service.planet.CreatePlanetResponse;
import com.serg1o.martian_robots.application.service.robot.RunRobots;
import com.serg1o.martian_robots.application.service.robot.RunRobotsRequest;
import com.serg1o.martian_robots.application.service.robot.RunRobotsResponse;
import com.serg1o.martian_robots.domain.model.mission.Mission;
import com.serg1o.martian_robots.domain.model.planet.Planet;
import com.serg1o.martian_robots.infrastructure.input.BoundaryFileInputParser;
import com.serg1o.martian_robots.infrastructure.input.MissionFileInputParser;
import com.serg1o.martian_robots.infrastructure.planet.DefaultPlanetFactory;
import com.serg1o.martian_robots.infrastructure.robot.MartianRobotBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class MarsMissionControlCenter {
    private static final int MAX_COORDINATE_VALUE = 50;
    private static final int MAX_LINE_LENGTH = 100;
    private static final Logger LOGGER = Logger.getLogger(MarsMissionControlCenter.class.getName());

    private final String filename;

    public MarsMissionControlCenter(String filename) {
        this.filename = filename;
    }

    private void executeInput() {
        CreatePlanet createPlanet = new CreatePlanet(
                new BoundaryFileInputParser(filename),
                new DefaultPlanetFactory()
        );
        CreatePlanetResponse createPlanetResponse = createPlanet.execute();
        Planet planet = createPlanetResponse.getPlanet();

        CreateMissions createMissions = new CreateMissions(
                new MissionFileInputParser(
                        MAX_LINE_LENGTH,
                        filename,
                        new MartianRobotBuilder(planet)
                )
        );
        CreateMissionsRequest createMissionsRequest = new CreateMissionsRequest(MAX_COORDINATE_VALUE);
        CreateMissionsResponse createMissionsResponse = createMissions.execute(createMissionsRequest);
        List<Mission> missions = createMissionsResponse.getMissions();

        RunRobots service = new RunRobots();
        RunRobotsRequest request = new RunRobotsRequest(missions);
        RunRobotsResponse response = service.execute(request);

        System.out.println(response.getOutput());
    }

    public static void main(String[] args) {
        LOGGER.fine("Executing application. Command line args: " + Arrays.toString(args));

        if (args == null || args.length != 1) {
            LOGGER.info("No command line argument provide. Terminating program...");
            System.out.println("Please provide full file path as command line argument");
            System.exit(1);
        }

        String filename = args[0];
        LOGGER.fine("Executing application with file " + filename);

        try {
            MarsMissionControlCenter instance = new MarsMissionControlCenter(filename);
            instance.executeInput();

            LOGGER.fine("Done :)");
        }
        catch (Exception e) {
            LOGGER.severe("Unexpected exception: " + e.getMessage());
            System.exit(1);
        }
    }
}
