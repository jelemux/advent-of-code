package dev.jelemux.day5;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.Test;

/**
 * This test is to determine if the input includes only horizontal vertical or diagonal data.
 * If it does, I have to do less work for exercise, because my model doesn't have to account for anything else.
 */
public class HorizontalVerticalOrDiagonalTest {
    
    @Test
    public void test() {
        try (final var reader = new VentLineReader("day5/input")) {
            Optional<VentLine> line;
            while ((line = reader.readVentLine()).isPresent()) {
                final var ventLine = line.get();
                assertTrue(
                        "Line is not horizonal, vertical or diagonal. Get to work you lazy bastard!",
                        ventLine.isHorizonal() || ventLine.isVertical() || ventLine.isDiagonal()
                );
            }
        } catch (IOException | URISyntaxException e) {

        }
        System.out.println("Yay, easier work for me!");
    }

}
