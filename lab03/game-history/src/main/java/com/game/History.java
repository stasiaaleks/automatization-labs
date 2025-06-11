package com.game;

import java.util.*;

public class History {
    private final List<Match> records = new ArrayList<>();

    public List<Match> getAllRecords() {
        return new ArrayList<>(records);
    }

    public int getTotalGames() {
        return records.size();
    }

    public void addGame(GameOutcome gameResult) {
        records.add(new Match(gameResult));
    }

    public long getWins() {
        return records.stream()
                .map(record -> record.getGameResult().getResult())
                .filter("WIN"::equals)
                .count();
    }

    public long getLosses() {
        return records.stream()
                .map(record -> record.getGameResult().getResult())
                .filter("LOSE"::equals)
                .count();
    }

    public long getDraws() {
        return records.stream()
                .map(record -> record.getGameResult().getResult())
                .filter("DRAW"::equals)
                .count();
    }
}