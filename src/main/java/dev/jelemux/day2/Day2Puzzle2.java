package dev.jelemux.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day2Puzzle2 {
    
    public static Position calculatePosition() {
        final var position = new Position(0, 0, 0);
        var aim = 0;

        try (var reader = Util.readFromFile(); var lines = reader.lines()) {
            lines.forEach(l -> {
                var instructions = l.split(" ");
                var direction = instructions[0];
                var distance = Integer.parseInt(instructions[1]);
                switch (direction) {
                    case "forward":
                        position.addToHorizontal(distance);
                        position.addToDepth(position.getAim() * distance);
                        break;
                    case "down":
                        position.addToAim(distance);
                        break;
                    case "up":
                        position.addToAim(-distance);
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
