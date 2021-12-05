package dev.jelemux.day4;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WinningState {
    
    private final BingoBoard board;

    private final int lastDrawnNumber;

    public int calculateScore() {
        final var sumOfUnmarked = this.board.sumOfUnmarkedFields();
        return this.lastDrawnNumber * sumOfUnmarked;
    }

}
