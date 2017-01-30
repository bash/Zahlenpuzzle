package rubys.ninja.experiments.zahlenpuzzle.view;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.HardcodedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.game.*;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

public class DirectionController {
    private Game game;

    public DirectionController(DirectionRequester input) {
        game = new SinglePlayerGame(new HardcodedInitializer(), () -> convertDirectionToSwapRequest(input.getDirection()), new OneEmptyAndSortedNumericRuleEnforcer());
    }

    public InputRequester.SwapRequest convertDirectionToSwapRequest(DirectionRequester.Direction direction) {
        BoardSize emptyPos = null;
        Board board = game.getBoard();
        BoardSize boardSize = board.getSize();

        outerLoop:
        for (int i = 0; i < boardSize.getHeight(); i++) {
            for (int j = 0; j < boardSize.getWidth(); j++) {
                BoardSize pos = new BoardSize(j, i);
                Token token = board.getTokenAt(pos);
                if (token instanceof EmptyToken){
                    emptyPos = pos;
                    break outerLoop;
                }
            }
        }

        if (emptyPos == null){
            throw new RuntimeException("No empty token found");
        }

        BoardSize otherPos = null;
        switch (direction) {
            case up:
                otherPos = new BoardSize(emptyPos.getWidth(), emptyPos.getHeight() - 1);
                break;
            case right:
                otherPos = new BoardSize(emptyPos.getWidth() + 1, emptyPos.getHeight());
                break;
            case down:
                otherPos = new BoardSize(emptyPos.getWidth(), emptyPos.getHeight() + 1);
                break;
            case left:
                otherPos = new BoardSize(emptyPos.getWidth() - 1, emptyPos.getHeight());
                break;
        }

        InputRequester.SwapRequest swapRequest = new InputRequester.SwapRequest();
        swapRequest.pos1 = emptyPos;
        swapRequest.pos2 = otherPos;
        return swapRequest;
    }

    public Game.UpdateResult update() {
        return game.update();
    }

    public Board getBoard() {
        return game.getBoard();
    }

}
