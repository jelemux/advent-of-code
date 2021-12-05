package dev.jelemux.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BingoGame {

    private final int[] drawnNumbers;

    private final Map<Integer, List<BingoField>> numberMapping = new HashMap<>();

    public void addField(final BingoField field) {
        if (numberMapping.get(field.getNumber()) == null) {
            final var fieldList = new ArrayList<BingoField>();
            fieldList.add(field);
            numberMapping.put(field.getNumber(), fieldList);
        } else {
            numberMapping.get(field.getNumber()).add(field);
        }
    }

    @NonNull
    private Optional<WinningState> checkNumber(final int number) {
        final var fields = this.numberMapping.get(number);
        for (final var field: fields) {
            final var bingo = field.check();
            if (bingo) {
                final var winningState = new WinningState(field.getRow().getBoard(), number);
                return Optional.of(winningState);
            }
        }
        return Optional.empty();
    }

    @NonNull
    private List<WinningState> checkNumbers(final int[] numbers) {
        final var winningOrder = new ArrayList<WinningState>();
        for (final var number: numbers) {
            final var winner = this.checkNumber(number);
            if (winner.isPresent()) {
                winningOrder.add(winner.get());
            }
        }
        return winningOrder;
    }

    @NonNull
    public List<WinningState> calculateWinningOrder() {
        final var winningOrder = checkNumbers(drawnNumbers);

        for (final var ws : winningOrder) {
            System.out.println("Board: " + ws.getBoard().getId() + "; Score: " + ws.getScore());
        }

        return winningOrder;
    }
    
}
