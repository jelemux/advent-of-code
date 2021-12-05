package dev.jelemux.day4;

import org.junit.Test;

public class Day4Test {
    
    @Test
    public void puzzle1Test() {
        final var winningScore = Day4Puzzle.calculateWinningScore();
        System.out.println(Day4Puzzle.class.getName());
        System.out.println("Winning Score: " + winningScore);
    }
    
    @Test
    public void puzzle2Test() {
        final var loosingScore = Day4Puzzle.calculateLoosingScore();
        System.out.println(Day4Puzzle.class.getName());
        System.out.println("Loosing Score: " + loosingScore);
    }
    
}
