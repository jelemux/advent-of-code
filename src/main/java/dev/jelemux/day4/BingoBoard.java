package dev.jelemux.day4;

import java.util.Arrays;
import java.util.stream.Stream;
import lombok.Getter;

public class BingoBoard {

    @Getter
    private final int id;

    private final BingoColumnRow[] rows;

    private final BingoColumnRow[] columns;

    @SuppressWarnings("LeakingThisInConstructor")
    public BingoBoard(final int id, final BingoColumnRow[] rows, final BingoColumnRow[] columns) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        for (final var row: this.rows) {
            row.setBoard(this);
        }
        for (final var column: this.columns) {
            column.setBoard(this);
        }
    }

    /**
     * Checks if the board has a bingo.
     * 
     * Considerably slower than checking for a bingo through the column or row when setting the checked mark on the field.
     * Use a Map with the numbers as keys and Lists of BingoField as values to check the numbers 
     * and then check if there's a bingo immediately.
     */
    public boolean isBingo() {
        for (final var row: this.rows) {
            if (row.isBingo()) {
                return true;
            }
        }
        for (final var column: this.columns) {
            if (column.isBingo()) {
                return true;
            }
        }
        return false;
    }
    
    public int sumOfUnmarkedFields() {
        return Stream.concat(Arrays.stream(rows), Arrays.stream(columns))
                .mapToInt(rc -> rc.sumOfUnmarkedFields())
                .sum();
    }
    
}
