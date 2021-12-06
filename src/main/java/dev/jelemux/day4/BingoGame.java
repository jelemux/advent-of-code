package dev.jelemux.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<WinningState> checkNumber(final int number) {
        final var winningOrder = new ArrayList<WinningState>();
        final var fields = this.numberMapping.get(number);
        for (final var field: fields) {
            final var bingo = field.check();
            if (bingo) {
                final var winningState = new WinningState(field.getRow().getBoard(), number);
                winningOrder.add(winningState);
            }
        }
        return winningOrder;
    }

    @NonNull
    private List<WinningState> checkNumbers(final int[] numbers) {
        final var winningOrder = new ArrayList<WinningState>();
        for (final var number: numbers) {
            final var winners = this.checkNumber(number);
            winningOrder.addAll(winners);
        }
        return winningOrder;
    }

    @NonNull
    public List<WinningState> calculateWinningOrder() {
        return checkNumbers(drawnNumbers);
    }
    
}
