package com.game;

public class GameOutcome {
    private final Move playerMove;
    private final Move computerMove;
    private final String result;

    public GameOutcome(Move playerMove, Move computerMove, String result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public Move getPlayerMove() { return playerMove; }
    public Move getComputerMove() { return computerMove; }
    public String getResult() { return result; }

    @Override
    public String toString() {
        return String.format("Player: %s, Computer: %s, Result: %s",
                playerMove.getDisplayName(),
                computerMove.getDisplayName(),
                result);
    }
}