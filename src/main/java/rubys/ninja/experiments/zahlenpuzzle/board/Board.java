package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.List;

public class Board {
    private BoardSize size;
    private List<Token> tokens;

    public Board(BoardInitializer initializer) {
        this.size = initializer.getBoardSize();
        this.tokens = initializer.getTokens();
    }

    public Token getTokenAt(BoardSize location) throws Exception {
        return null;
    }

    public BoardSize getSize() {
        return size;
    }

    public void swapTokens(BoardSize pos1, BoardSize pos2) throws Exception {
    }
}
