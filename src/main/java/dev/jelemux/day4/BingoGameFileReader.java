package dev.jelemux.day4;

import dev.jelemux.util.FileUtil;
import java.io.IOException;
import java.net.URISyntaxException;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Optional;

public class BingoGameFileReader implements AutoCloseable {

    private final int boardSize;

    private final BufferedReader reader;

    private BingoGame game;

    public BingoGameFileReader(final String path, final int boardSize) 
            throws URISyntaxException, IOException {
        this.reader = FileUtil.readFromFile(path);
        this.boardSize = boardSize;
    }

    public BingoGame readGame() throws IOException {
        final var drawnNumbers = Arrays.stream(
            this.reader.readLine().split(",")
        ).mapToInt(Integer::valueOf).toArray();

        this.game = new BingoGame(drawnNumbers);

        var id = 0;
        while (this.readBoard(id).isPresent()) {
            id++;
        }

        return this.game;
    }

    private Optional<BingoBoard> readBoard(final int id) throws IOException {
        if (this.reader.readLine() == null) {
            return Optional.empty();
        }

        final var rows = new BingoColumnRow[this.boardSize];
        final var columns = new BingoColumnRow[this.boardSize];

        final var columnFields = new BingoField[this.boardSize][this.boardSize];
        for (var r = 0; r < this.boardSize; r++) {
            final var line = this.reader.readLine();
            if (line == null) {
                return Optional.empty();
            }

            final var rowFields = Arrays.stream(
                line.trim().split("\\s+")
            ).map(s -> new BingoField(Integer.valueOf(s))).toArray(BingoField[]::new);

            final var row = new BingoColumnRow(rowFields, true);
            rows[r] = row;

            for (var c = 0; c < this.boardSize; c++) {
                this.game.addField(rowFields[c]);
                columnFields[c][r] = rowFields[c];
            }
        }
        for (var c = 0; c < this.boardSize; c++) {
            columns[c] = new BingoColumnRow(columnFields[c], false);
        }

        final var board = new BingoBoard(id, rows, columns);
        return Optional.of(board);
    }

    @Override
    public void close() throws IOException {
        this.reader.close();
    }
    
}
