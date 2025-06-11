package com.game;

import java.util.Random;

public class GameService {
    private final Random random = new Random();

    public GameOutcome play(Move playerMove) {
        Move computerMove = generateRandomComputerMove();
        String outcome = resolveResult(playerMove, computerMove);

        return new GameOutcome(playerMove, computerMove, outcome);
    }

    private Move generateRandomComputerMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    private String resolveResult(Move playerMove, Move computerMove) {
        if (playerMove == computerMove) {
            return "DRAW";
        } else if (playerMove.beats(computerMove)) {
            return "WIN";
        } else {
            return "LOSS";
        }
    }
}
