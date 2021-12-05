package dev.jelemux.day4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class BingoField {

    private final int number;

    private boolean checked = false;

    @Setter
    private BingoColumnRow row;

    @Setter
    private BingoColumnRow column;

    public boolean check() {
        this.checked = true;
        return this.row.isBingo() || this.column.isBingo();
    }
    
}
