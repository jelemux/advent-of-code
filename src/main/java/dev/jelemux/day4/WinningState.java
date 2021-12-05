package dev.jelemux.day4;

import lombok.Getter;

public class WinningState {
    
    @Getter
    private final BingoBoard board;

    private final int lastDrawnNumber;

    @Getter
    private final int score;

    public WinningState(final BingoBoard board, final int lastDrawnNumber) {
        this.board = board;
        this.lastDrawnNumber = lastDrawnNumber;
        this.score = this.calculateScore();
    }

    private int calculateScore() {
        final var sumOfUnmarked = this.board.sumOfUnmarkedFields();
        return this.lastDrawnNumber * sumOfUnmarked;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WinningState)) {
            return false;
        }
        final var otherState = (WinningState) o;
        return otherState.getBoard().equals(this.getBoard());
    }

    @Override
    public int hashCode() {
        return this.board.hashCode() * 777;
    }

}
