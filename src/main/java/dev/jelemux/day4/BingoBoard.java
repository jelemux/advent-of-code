package dev.jelemux.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (final var row : this.rows) {
            if (row.isBingo()) {
                return true;
            }
        }
        for (final var column : this.columns) {
            if (column.isBingo()) {
                return true;
            }
        }
        return false;
    }
    
    public int sumOfUnmarkedFields() {
        return this.getAllFields()
                .stream()
                .filter(f -> !f.isChecked())
                .distinct()
                .mapToInt(BingoField::getNumber)
                .sum();
    }

    private List<BingoField> getAllFields() {
        final var fieldList = new ArrayList<BingoField>();
        for (final var row : this.rows) {
            fieldList.addAll(Arrays.asList(row.getFields()));
        }
        for (final var column : this.columns) {
            fieldList.addAll(Arrays.asList(column.getFields()));
        }
        return fieldList;
    }
    
}
