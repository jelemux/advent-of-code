package dev.jelemux.day1;

public class Day1Puzzle2 {

    private Day1Puzzle2() {
    }

    static int calculateIncreaseCount(int[] measurements) {
        var increaseCount = 0;
        if (measurements.length <= 0) {
            return increaseCount;
        }
        for (var i = 0; i < measurements.length - 3; i++) {
            final var previousWindow = calculateWindow(i, measurements);
            final var nextWindow = calculateWindow(i + 1, measurements);
            if (previousWindow < nextWindow) {
                increaseCount++;
            }
        }

        return increaseCount;
    }

    private static int calculateWindow(int index, int[] measurements) {
        var sum = 0;
        for (var n = 0; n < 3; n++) {
            sum += measurements[index + n];
        }
        return sum;
    }
    
}
