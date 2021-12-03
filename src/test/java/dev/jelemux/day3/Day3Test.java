package dev.jelemux.day3;

import org.junit.Test;

public class Day3Test {
    
    @Test
    public void puzzle1Test() {
        var powerConsumption = Day3Puzzle1.calculatePowerConsumption();
        System.out.println(Day3Puzzle1.class.getName());
        System.out.println("Power consumption: " + powerConsumption);
    }
    
    @Test
    public void puzzle2Test() {
        var lifeSupportRating = Day3Puzzle2.calculateLifeSupportRating();
        System.out.println(Day3Puzzle2.class.getName());
        System.out.println("Life support rating: " + lifeSupportRating);
    }
    
}
