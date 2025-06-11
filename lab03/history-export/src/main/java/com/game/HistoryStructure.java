package com.game;

import java.util.List;

public class HistoryStructure {
    public List<Match> gameHistory;
    public Statistics statistics;

    public HistoryStructure(List<Match> gameHistory, int totalGames, long wins, long losses, long draws) {
        this.gameHistory = gameHistory;
        this.statistics = new Statistics(totalGames, wins, losses, draws);
    }

    public static class Statistics {
        public int totalGames;
        public long wins;
        public long losses;
        public long draws;

        public Statistics(int totalGames, long wins, long losses, long draws) {
            this.totalGames = totalGames;
            this.wins = wins;
            this.losses = losses;
            this.draws = draws;
        }
    }
}