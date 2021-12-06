package dev.jelemux.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import dev.jelemux.util.FileUtil;

public class VentLineReader implements AutoCloseable {

    private final BufferedReader reader;

    public VentLineReader(final String path) 
            throws URISyntaxException, IOException {
        this.reader = FileUtil.readFromFile(path);
    }

    public Optional<VentLine> readVentLine() throws IOException {
        final var rawLine = this.reader.readLine();
        if (rawLine == null || rawLine.isBlank()) {
            return Optional.empty();
        }

        final var rawPoints = rawLine.split(" -> ");
        if (rawPoints.length != 2) {
            return Optional.empty();
        }
        final var beginning = readPoint(rawPoints[0]);
        final var end = readPoint(rawPoints[1]);
        if (beginning.isPresent() && end.isPresent()) {
            final var ventLine = new VentLine(beginning.get(), end.get());
            return Optional.of(ventLine);
        }
        return Optional.empty();
    }

    private Optional<Point> readPoint(final String rawPoint) {
        final var rawXY = rawPoint.split(",");
        if (rawXY.length != 2) {
            return Optional.empty();
        }
        final var x = Integer.valueOf(rawXY[0]);
        final var y = Integer.valueOf(rawXY[1]);
        final var point = new Point(x, y);
        return Optional.of(point);
    }

    @Override
    public void close() throws IOException {
        this.reader.close();
    }
    
}
