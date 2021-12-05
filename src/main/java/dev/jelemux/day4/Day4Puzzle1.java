package dev.jelemux.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day4Puzzle1 {

    public static int calculateWinningScore() {
        try (final var gameReader = new BingoGameFileReader("day4/input", 5)) {
            final var game = gameReader.readGame();
            final var winner = game.calculateWinner();
            if (winner.isPresent()) {
                return winner.get().calculateScore();
            } else {
                Logger.getLogger(Day4Puzzle1.class.getName()).log(Level.SEVERE, "Winner could not be determined.");
                return -1;
            }
        } catch (IOException | URISyntaxException e) {
            Logger.getLogger(Day4Puzzle1.class.getName()).log(Level.SEVERE, "Unexpected Exception", e);
            return -1;
        }
    }
}
