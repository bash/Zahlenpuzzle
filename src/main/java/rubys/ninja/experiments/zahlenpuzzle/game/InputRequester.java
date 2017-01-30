package rubys.ninja.experiments.zahlenpuzzle.game;

import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

/**
 * Created by jn_fe on 30.01.2017.
 */
public interface InputRequester {
    class SwapRequest {
        public BoardSize pos1;
        public BoardSize pos2;
    }

    SwapRequest getInput();
}
