package com.serg1o.martian_robots.infrastructure.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public abstract class AbstractFileInputParser {
    private static final Logger LOGGER = Logger.getLogger(AbstractFileInputParser.class.getName());
    protected final String filename;

    protected AbstractFileInputParser(String filename) {
        this.filename = filename;
    }

    protected Stream<String> getFileContent() {
        try {
            return Files.lines(Paths.get(filename));
        }
        catch (IOException e) {
            LOGGER.severe("Unable to open file: " + e.getMessage());
            return Stream.empty();
        }
    }
}
