package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.Token;

public class Board {
    private BoardSize size;

    public Board(BoardSize size) {
        this.size = size;
    }

    public Token getTokenAt(BoardSize location) {
        return null;
    }

    public BoardSize getSize() {
        return size;
    }
}
