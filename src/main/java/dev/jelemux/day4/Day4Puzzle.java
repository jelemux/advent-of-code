package dev.jelemux.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day4Puzzle {

    public static int calculateWinningScore() {
        return calculateWinningOrder()
                .get(0).getScore();
    }

    public static int calculateLoosingScore() {
        final var looser = calculateWinningOrder()
                .stream()
                .distinct()
                .reduce((current, next) -> next);
        if (looser.isPresent()) {
            return looser.get().getScore();
        } else {
            return -1;
        }
    }

    @NonNull
    private static List<WinningState> calculateWinningOrder() {
        try (final var gameReader = new BingoGameFileReader("day4/input", 5)) {
            final var game = gameReader.readGame();
            return game.calculateWinningOrder();
        } catch (IOException | URISyntaxException e) {
            Logger.getLogger(Day4Puzzle.class.getName()).log(Level.SEVERE, "Unexpected Exception", e);
            return new ArrayList<>();
        }
    }
}
