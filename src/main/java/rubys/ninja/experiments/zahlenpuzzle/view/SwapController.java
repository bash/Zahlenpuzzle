package rubys.ninja.experiments.zahlenpuzzle.view;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.HardcodedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.game.Game;
import rubys.ninja.experiments.zahlenpuzzle.game.InputRequester;
import rubys.ninja.experiments.zahlenpuzzle.game.OneEmptyAndSortedNumericRuleEnforcer;
import rubys.ninja.experiments.zahlenpuzzle.game.SinglePlayerGame;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

public class SwapController {
    private Game game;

    public SwapController(InputRequester input) {
        game = new SinglePlayerGame(new HardcodedInitializer(), input, new OneEmptyAndSortedNumericRuleEnforcer());
    }

    public Game.UpdateResult update() {
        return game.update();
    }

    public Board getBoard() {
        return game.getBoard();
    }

}
