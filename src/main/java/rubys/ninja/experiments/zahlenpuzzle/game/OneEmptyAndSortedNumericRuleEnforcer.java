package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;


public class OneEmptyAndSortedNumericRuleEnforcer implements RuleEnforcer {
    public boolean isAllowedToSwap(Board board, BoardSize pos1, BoardSize pos2) {
        Token token1;
        Token token2;

        try {
            token1 = board.getTokenAt(pos1);
            token2 = board.getTokenAt(pos2);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return false;
        }

        boolean token1IsEmpty = token1 instanceof EmptyToken;
        boolean token2IsEmpty = token2 instanceof EmptyToken;

        boolean areAdjacent = board.areAdjacent(pos1, pos2);
        boolean oneIsEmpty = token1IsEmpty != token2IsEmpty;

        return areAdjacent && oneIsEmpty;
    }

    public boolean isFinished(Board board) {
        BoardSize boardSize = board.getSize();
        int maxIndex = boardSize.getHeight() * boardSize.getWidth() - 1;

        for (int i = 0; i < maxIndex; i++) {
            Token token = board.getTokenAt(i);

            if (!(token instanceof NumericalToken)) {
                return false;
            }

            NumericalToken numericalToken = (NumericalToken) token;
            int value = numericalToken.getValue();
            int expected = i + 1;

            if (value != expected) {
                return false;
            }
        }


        return board.getTokenAt(maxIndex) instanceof EmptyToken;
    }
}
