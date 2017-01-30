package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

public interface RuleEnforcer {
    boolean isAllowedToSwap(Board board, BoardSize pos1, BoardSize pos2);

    boolean isFinished(Board board);
}
