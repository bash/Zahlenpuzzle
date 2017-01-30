package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

public interface InputRequester {
    class SwapRequest {
        public BoardSize pos1;
        public BoardSize pos2;
    }

    SwapRequest getInput();
}
