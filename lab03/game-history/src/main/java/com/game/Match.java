package com.game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Match {
    private final GameOutcome gameResult;
    private final LocalDateTime recordTime;

    public Match(GameOutcome gameResult) {
        this.gameResult = gameResult;
        this.recordTime = LocalDateTime.now();
    }

    public GameOutcome getGameResult() {
        return gameResult;
    }
    public String getFormattedTime() {
        return recordTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
