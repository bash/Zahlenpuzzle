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
        int index = getIndexFromLocation(location);

        return tokens.get(index);
    }

    public BoardSize getSize() {
        return size;
    }

    public void swapTokens(BoardSize pos1, BoardSize pos2) throws Exception {
        Token token1 = getTokenAt(pos1);
        Token token2 = getTokenAt(pos2);

        int index1 = getIndexFromLocation(pos1);
        int index2 = getIndexFromLocation(pos2);

        tokens.set(index1, token2);
        tokens.set(index2, token1);
    }

    private int getIndexFromLocation(BoardSize location) {
        return location.getHeight() * size.getWidth() + location.getWidth();
    }
}
