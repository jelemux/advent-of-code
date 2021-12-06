package dev.jelemux.day5;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class Day5Test {

    @Test
    public void testPuzzle1() {
        final var intersectionCalculator = new IntersectionCalculator();
            
        try (final var reader = new VentLineReader("day5/input")) {
            var line = reader.readVentLine();
            while (line.isPresent()) {
                final var ventLine = line.get();
                if (ventLine.isHorizonal() || ventLine.isVertical()) {
                    intersectionCalculator.addVentLine(ventLine);
                }

                line = reader.readVentLine();
            }
        } catch (IOException | URISyntaxException e) {
        }
        
        System.out.println("Number of Intersections: " + intersectionCalculator.countIntersections());
    }
    
}
