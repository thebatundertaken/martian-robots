package com.serg1o.martian_robots.infrastructure.input;

import java.util.function.UnaryOperator;

public class FileLineSanitizer implements UnaryOperator<String> {
    @Override
    public String apply(String line) {
        return line.trim().toUpperCase();
    }
}