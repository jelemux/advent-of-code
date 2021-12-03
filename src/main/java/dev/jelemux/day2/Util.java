package dev.jelemux.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static BufferedReader readFromFile() throws URISyntaxException, IOException {
        final var inputURL = Util.class.getClassLoader().getResource("day2/input");

        final var inputPath = Paths.get(inputURL.toURI());
        return Files.newBufferedReader(inputPath);
    }
    
}
