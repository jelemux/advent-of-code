package dev.jelemux.day4;

import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;

public class BingoColumnRow {

    private final BingoField[] fields;

    @Setter
    @Getter
    private BingoBoard board;

    @SuppressWarnings("LeakingThisInConstructor")
    public BingoColumnRow(final BingoField[] fields, final boolean isRow) {
        this.fields = fields;
        for (final var field: this.fields) {
            if (isRow) {
                field.setRow(this);
            } else {
                field.setColumn(this);
            }
        }
    }

    public boolean isBingo() {
        for (final var field: this.fields) {
            if (!field.isChecked()) {
                return false;
            }
        }
        return true;
    }

    public int sumOfUnmarkedFields() {
        return Arrays.stream(fields)
                .filter(f -> !f.isChecked())
                .mapToInt(f -> f.getNumber())
                .sum();
    }
    
}
