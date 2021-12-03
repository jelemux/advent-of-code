package dev.jelemux.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dev.jelemux.util.FileUtil;

public class Day3Puzzle1 {
    
    public static int calculatePowerConsumption() {
        try (final var reader = FileUtil.readFromFile("day3/input")) {
            int lineCount = 0;

            int lineLength = 0;
            int[] countOfOnes = null;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (countOfOnes == null) {
                    lineLength = line.length();
                    countOfOnes = new int[lineLength];
                }
                for (int i = 0; i < line.length(); i++) {
                    final var c = line.charAt(i);
                    if (c == '1') {
                        countOfOnes[i] += 1;
                    }
                }
            }

            var gamma = 0;
            for (int i = 0; i < lineLength; i++) {
                final var uIndex = lineLength - i - 1;
                if (countOfOnes[uIndex] > lineCount / 2) {
                    gamma += Math.pow(2, i);
                }
            }

            final var mask = ((int) Math.pow(2, Integer.toString(gamma, 2).length())) - 1;
            final var epsilon = ~gamma & mask;

            return gamma * epsilon;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Day3Puzzle2.class.getName()).log(Level.SEVERE, "Unexpected Exception", ex);
            return 0;
        }
    }

}
