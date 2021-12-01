package dev.jelemux.day1;

/**
 * Hello world!
 *
 */
public class Day1Puzzle1 {

    private Day1Puzzle1() {
    }

    static int calculateIncreaseCount(int[] measurements) {
        var increaseCount = 0;
        if (measurements.length <= 0) {
            return increaseCount;
        }
        for (var i = 0; i < measurements.length - 1; i++) {
            if (measurements[i] < measurements[i + 1]) {
                increaseCount++;
            }
        }

        return increaseCount;
    }
}
