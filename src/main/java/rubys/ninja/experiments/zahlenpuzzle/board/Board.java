package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.Token;

public class Board {
    private BoardSize size;

    public Board(BoardSize size) {
        this.size = size;
    }

    public Token getTokenAt(BoardSize location) throws Exception {
        return null;
    }

    public BoardSize getSize() {
        return size;
    }

    public void swapTokens(BoardSize pos1, BoardSize pos2) throws Exception {{

    }
}
