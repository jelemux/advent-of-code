package dev.jelemux.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static BufferedReader readFromFile(String pathString) throws URISyntaxException, IOException {
        final var inputURL = FileUtil.class.getClassLoader().getResource(pathString);

        final var inputPath = Paths.get(inputURL.toURI());
        return Files.newBufferedReader(inputPath);
    }
    
}
