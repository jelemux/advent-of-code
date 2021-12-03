package dev.jelemux.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import dev.jelemux.util.FileUtil;

public class Day3Puzzle2 {
    
    public static Integer calculateLifeSupportRating() {
        try (final var reader = FileUtil.readFromFile("day3/input"); final var lines = reader.lines()) {
            final var numbers = lines.collect(Collectors.toList());

            final var oxygenGeneratorRating = calculatePartialRating(true, numbers);
            final var co2ScrubberRating = calculatePartialRating(false, numbers);

            return oxygenGeneratorRating * co2ScrubberRating;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Day3Puzzle2.class.getName()).log(Level.SEVERE, "Unexpected Exception", ex);
            return null;
        }

    }

    private static int calculatePartialRating(final boolean isOxygen, final List<String> numbers) {
        var filteredNumbers = numbers;
        var position = 0;

        while (filteredNumbers.size() > 1) {
            final var zeroes = new ArrayList<String>();
            final var ones = new ArrayList<String>();

            for (final var filteredNumber : filteredNumbers) {
                final var charAtPosition = filteredNumber.charAt(position);
                if (charAtPosition == '0') {
                    zeroes.add(filteredNumber);
                } else if (charAtPosition == '1') {
                    ones.add(filteredNumber);
                }
            }

            final var zeroesIsLonger = zeroes.size() > ones.size();
            if (isOxygen && zeroes.size() == ones.size()) {
                filteredNumbers = ones;
            } else if (!isOxygen && zeroes.size() == ones.size()) {
                filteredNumbers = zeroes;
            } else if (zeroesIsLonger) {
                if (isOxygen) {
                    filteredNumbers = zeroes;
                } else {
                    filteredNumbers = ones;
                }
            } else {
                if (isOxygen) {
                    filteredNumbers = ones;
                } else {
                    filteredNumbers = zeroes;
                }
            }

            position++;
        }
        
        return Integer.parseInt(filteredNumbers.get(0), 2);
    }

}
