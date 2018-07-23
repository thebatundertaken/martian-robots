package com.serg1o.martian_robots.infrastructure.input;

import com.serg1o.martian_robots.domain.model.Boundary;
import com.serg1o.martian_robots.domain.model.Coordinate;
import com.serg1o.martian_robots.domain.model.input.BoundaryInputParser;

import java.util.Optional;
import java.util.stream.Stream;

public class BoundaryFileInputParser extends AbstractFileInputParser implements BoundaryInputParser {

    public BoundaryFileInputParser(String filename) {
        super(filename);
    }

    @Override
    public Boundary parseInput() {
        return getBoundary(getFileContent());
    }

    private Boundary getBoundary(Stream<String> stream) {
        Optional<Boundary> result = stream
                .sequential()
                .limit(1)
                .map(new FileLineSanitizer())
                .map(
                        (line) -> {
                            String[] split = line.split("\\s");
                            if (split.length != 2) {
                                throw new IllegalArgumentException("Invalid boundary format");
                            }

                            return new Boundary(
                                    Coordinate.of(0, 0),
                                    Coordinate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]))
                            );
                        }
                )
                .findFirst();

        if (!result.isPresent()) {
            throw new IllegalArgumentException("Invalid planet file content");
        }

        return result.get();
    }
}
