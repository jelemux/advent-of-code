package dev.jelemux.day2;

import org.junit.Test;

public class Day2Test {
    
    @Test
    public void puzzle1Test() {
        var position = Day2Puzzle1.calculatePosition();
        System.out.println(Day2Puzzle1.class.getName());
        System.out.println("Horizontal: " + position.getHorizonal() + "; Depth: " + position.getDepth());
        System.out.println("Result: " + (position.getHorizonal() * position.getDepth()));
    }
    
    @Test
    public void puzzle2Test() {
        var position = Day2Puzzle2.calculatePosition();
        System.out.println(Day2Puzzle2.class.getName());
        System.out.println("Horizontal: " + position.getHorizonal() + "; Depth: " + position.getDepth());
        System.out.println("Result: " + (position.getHorizonal() * position.getDepth()));
    }

}
