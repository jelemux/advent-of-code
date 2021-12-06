package dev.jelemux.day5;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class IntersectionCalculator {

    private final Map<Point, Integer> countingMap = new HashMap<>(1000000);

    public void addVentLine(final VentLine ventLine) {
        final var points = ventLine.getContainedPoints();
        for (final var point : points) {
            if (!this.countingMap.containsKey(point)) {
                this.countingMap.put(point, 1);
            } else {
                final var previousCount = this.countingMap.get(point);
                this.countingMap.put(point, previousCount + 1);
            }
        }
    }

    public int countIntersections() {
        var sum = 0;
        for (final var count : this.countingMap.values()) {
            if (count > 1) {
                sum++;
            }
        }

        return sum;
    }
    
}
