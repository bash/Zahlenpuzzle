package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;


public class OneEmptyAndSortedNumericRuleEnforcer implements RuleEnforcer {
    public boolean isAllowedToSwap(Board board, BoardSize pos1, BoardSize pos2) {
        return false;
    }

    public boolean isFinished(Board finishedBoard) {
        return false;
    }
}
