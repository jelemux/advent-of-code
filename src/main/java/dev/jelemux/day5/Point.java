package dev.jelemux.day5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;

@Getter
@With
@RequiredArgsConstructor
public class Point implements Subtraction<Point, Point>, Addition<Point, Point>, Multiplication<Integer, Point>, Division<Integer, Point> {

    private final int x;

    private final int y;

    @Override
    public Point subtract(Point subtrahend) {
        return new Point(this.x - subtrahend.getX(), this.y - subtrahend.getY());
    }

    @Override
    public Point add(Point summand) {
        return new Point(this.x + summand.getX(), this.y + summand.getY());
    }

    @Override
    public Point multiply(Integer factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    @Override
    public Point divide(Integer divisor) {
        return new Point(this.x / divisor, this.y / divisor);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        final var otherPoint = (Point) o;
        return this.x == otherPoint.getX() && this.y == otherPoint.getY();
    }

    @Override
    public int hashCode() {
        return (int) Math.pow(this.x, this.y);
    }
    
}
