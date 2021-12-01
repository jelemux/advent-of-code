package dev.jelemux.day1;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class Day1Puzzle1Test {
    
    @Test
    public void calculateIncreaseCount() throws URISyntaxException, IOException {
        int[] input = TestUtil.readMeasurementsFromFile();
        System.out.println("Number of Inputs: " + input.length);

        int result = Day1Puzzle1.calculateIncreaseCount(input);
        System.out.println("Increase Count Single: " + result);
    }
}
