package dev.jelemux.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dev.jelemux.util.FileUtil;

public class Day2Puzzle1 {
    
    public static Position calculatePosition() {
        var position = new Position(0, 0, 0);

        try (var reader = FileUtil.readFromFile("day2/input"); var lines = reader.lines()) {
            lines.forEach(l -> {
                var instructions = l.split(" ");
                var direction = instructions[0];
                var distance = Integer.parseInt(instructions[1]);
                switch (direction) {
                    case "forward":
                        position.addToHorizontal(distance);
                        break;
                    case "backward":
                        position.addToHorizontal(-distance);
                        break;
                    case "down":
                        position.addToDepth(distance);
                        break;
                    case "up":
                        position.addToDepth(-distance);
                        break;
                    default:
                        break;
                }
            });
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Day2Puzzle1.class.getName()).log(Level.SEVERE, "Unexpected Exception", ex);
        }

        return position;
    }

}
