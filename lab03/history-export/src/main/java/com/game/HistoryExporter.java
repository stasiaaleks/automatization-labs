package com.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;

public class HistoryExporter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        var game = new GameService();
        var history = new History();

        // several matches simulation
        history.addGame(game.play(Move.ROCK));
        history.addGame(game.play(Move.PAPER));
        history.addGame(game.play(Move.SCISSORS));
        history.addGame(game.play(Move.ROCK));

        HistoryExporter exporter = new HistoryExporter();
        String fileName = "game-history";
        exporter.exportToFile(history, fileName+".txt", ExportFormat.TXT);
        exporter.exportToFile(history, fileName+".csv", ExportFormat.CSV);
        exporter.exportToFile(history, fileName+".json", ExportFormat.JSON);
    }

    private void exportToFile(History history, String fileName, ExportFormat format) {
        try {
            switch (format) {
                case CSV -> exportToCsv(history, fileName);
                case JSON -> exportToJson(history, fileName);
                case TXT -> exportToTxt(history, fileName);
            }
            System.out.println("INFO LOG: History exported successfully to: " + fileName);
        } catch (IOException e) {
            System.err.println("INFO LOG: Error exporting history: " + e.getMessage());
        }
    }

    private void exportToCsv(History history, String fileName) throws IOException {
        try (var writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeNext(new String[]{"Time", "Player", "Computer", "Outcome"});
            for (Match match : history.getAllRecords()) {
                GameOutcome result = match.getGameResult();
                writer.writeNext(new String[]{
                        match.getFormattedTime(),
                        result.getPlayerMove().getDisplayName(),
                        result.getComputerMove().getDisplayName(),
                        result.getResult()
                });
            }
        }
    }

    private void exportToJson(History history, String fileName) throws IOException {
        var wrapper = new HistoryStructure(
                history.getAllRecords(),
                history.getTotalGames(),
                history.getWins(),
                history.getLosses(),
                history.getDraws()
        );

        var writer = objectMapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new FileWriter(fileName), wrapper);
    }

    private void exportToTxt(History history, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("ROCK-PAPER-SCISSORS GAME HISTORY\n");
            writer.printf("Total Games: %d%n", history.getTotalGames());
            writer.printf("Wins: %d%n", history.getWins());
            writer.printf("Losses: %d%n", history.getLosses());
            writer.printf("Draws: %d%n", history.getDraws());
            writer.println();
            writer.println("History:");
            for (Match record : history.getAllRecords()) {
                writer.printf("[%s] %s%n",
                        record.getFormattedTime(),
                        record.getGameResult().toString()
                );
            }
        }
    }
}
