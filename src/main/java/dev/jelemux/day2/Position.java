package dev.jelemux.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Position {

    private int horizonal;

    private int depth;

    private int aim;
    
    public void addToHorizontal(int hIncrease) {
        horizonal += hIncrease;
    }

    public void addToDepth(int dIncrease) {
        depth += dIncrease;
    }

    public void addToAim(int aIncrease) {
        aim += aIncrease;
    }
}
