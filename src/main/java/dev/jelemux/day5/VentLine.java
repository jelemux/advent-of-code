package dev.jelemux.day5;

import java.util.HashSet;
import java.util.Set;

import dev.jelemux.util.MathUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class VentLine {

    private final Point beginning;

    private final Point end;

    @Getter(lazy = true)
    private final Point direction = caluculateDirection();

    private Point caluculateDirection() {
        return this.end.subtract(beginning);
    }

    public boolean isHorizonal() {
        return this.getDirection().getX() == 0;
    }

    public boolean isVertical() {
        return this.getDirection().getY() == 0;
    }

    public boolean isDiagonal() {
        return Math.abs(this.getDirection().getX()) == Math.abs(this.getDirection().getY());
    }

    public Set<Point> getContainedPoints() {
        final var containedPoints = new HashSet<Point>(1000);
        if (beginning.getX() == end.getX()) {
            final var numberOfPoints = Math.abs(this.beginning.getY() - this.end.getY()) + 1;
            for (var i = 0; i < numberOfPoints; i++) {
                final var point = this.beginning.withY(this.beginning.getY() + i);
                containedPoints.add(point);
            }
            return containedPoints;
        }
        if (beginning.getY() == end.getY()) {
            final var numberOfPoints = Math.abs(this.beginning.getX() - this.end.getX()) + 1;
            for (var i = 0; i < numberOfPoints; i++) {
                final var point = this.beginning.withX(this.beginning.getX() + i);
                containedPoints.add(point);
            }
            return containedPoints;
        }

        final var numberOfPoints = MathUtil.gcd(
            Math.abs(this.beginning.getX() - this.end.getX()), 
            Math.abs(this.beginning.getY() - this.end.getY())
        );
        final var step = this.getDirection().divide(numberOfPoints);
        for (var i = 0; i < numberOfPoints; i++) {
            final var point = this.beginning.add(
                    step.multiply(i));
            containedPoints.add(point);
        }
        return containedPoints;
    }
    
}
