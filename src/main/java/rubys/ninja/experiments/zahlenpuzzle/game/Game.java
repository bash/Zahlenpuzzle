package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;

public interface Game {
    enum UpdateResult {
        SuccessfulSwap,
        RequestDenied,
        GameFinished
    }
    Game.UpdateResult update();
    Board getBoard();
    boolean hasWon();
    boolean isFinished();
}
