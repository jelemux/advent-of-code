package dev.jelemux.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtil {

    public static int[] readMeasurementsFromFile() throws URISyntaxException, IOException {
        final var inputURL = TestUtil.class.getClassLoader().getResource("day1/input");

        final var inputPath = Paths.get(inputURL.toURI());
        return Files.readAllLines(inputPath).stream().mapToInt(Integer::parseInt).toArray();
    }
    
}
