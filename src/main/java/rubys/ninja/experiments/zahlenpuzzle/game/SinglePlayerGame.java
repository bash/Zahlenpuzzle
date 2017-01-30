package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardInitializer;

public class SinglePlayerGame implements Game {
    private Board board;
    private InputRequester inputRequester;
    private RuleEnforcer ruleEnforcer;

    public SinglePlayerGame(BoardInitializer initializer, InputRequester inputRequester, RuleEnforcer ruleEnforcer) {
        this.board = new Board(initializer);
        this.inputRequester = inputRequester;
        this.ruleEnforcer = ruleEnforcer;
    }

    public Game.UpdateResult update() {
        InputRequester.SwapRequest swapRequest = inputRequester.getInput();

        if (ruleEnforcer.isAllowedToSwap(board, swapRequest.pos1, swapRequest.pos2))
            board.swapTokens(swapRequest.pos1, swapRequest.pos2);
        else
            return UpdateResult.RequestDenied;

        if (isFinished())
            return UpdateResult.GameFinished;

        return UpdateResult.SuccessfulSwap;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasWon() {
        return isFinished();
    }

    public boolean isFinished() {
        return ruleEnforcer.isFinished(board);
    }
}
