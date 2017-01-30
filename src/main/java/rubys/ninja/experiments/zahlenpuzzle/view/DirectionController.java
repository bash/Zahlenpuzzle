package rubys.ninja.experiments.zahlenpuzzle.view;

import rubys.ninja.experiments.zahlenpuzzle.board.HardcodedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.game.Game;
import rubys.ninja.experiments.zahlenpuzzle.game.InputRequester;
import rubys.ninja.experiments.zahlenpuzzle.game.OneEmptyAndSortedNumericRuleEnforcer;
import rubys.ninja.experiments.zahlenpuzzle.game.SinglePlayerGame;

/**
 * Created by jn_fe on 30.01.2017.
 */
public class DirectionController {
    Game game;



    public DirectionController(InputRequester inputRequester) {
        game = new SinglePlayerGame(new HardcodedInitializer, inputRequester, new OneEmptyAndSortedNumericRuleEnforcer());
    }

    public InputRequester.SwapRequest ConvertDirectionToSwapRequest(DirectionRequester.Direction direction) {
        
    }

}
