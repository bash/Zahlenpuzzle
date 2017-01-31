package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.List;
import java.util.Objects;

public class Board {
    private BoardSize size;
    private List<Token> tokens;

    public Board(BoardInitializer initializer) {
        this.size = initializer.getBoardSize();
        this.tokens = initializer.getTokens();
    }

    public Token getTokenAt(BoardSize location) throws IndexOutOfBoundsException {
        int index = getIndexFromLocation(location);

        return tokens.get(index);
    }

    public Token getTokenAt(Integer location) throws IndexOutOfBoundsException {
        return tokens.get(location);
    }

    public BoardSize getSize() {
        return size;
    }

    public void swapTokens(BoardSize pos1, BoardSize pos2) throws IndexOutOfBoundsException {
        Token token1 = getTokenAt(pos1);
        Token token2 = getTokenAt(pos2);

        int index1 = getIndexFromLocation(pos1);
        int index2 = getIndexFromLocation(pos2);

        tokens.set(index1, token2);
        tokens.set(index2, token1);
    }

    public void moveTokensInLine(BoardSize from, BoardSize to) {
        if (Objects.equals(from.getWidth(), to.getWidth())) {
            int width = from.getWidth();
            int start = from.getHeight();
            int end = to.getHeight();
            int step = start < end ? 1 : -1;

            for (int i = start; i < end; i+=step){
                swapTokens(new BoardSize(width, i), new BoardSize(width, i+step));
            }
        }
        if (Objects.equals(from.getHeight(), to.getHeight())) {
            int height = from.getHeight();
            int start = from.getWidth();
            int end = to.getWidth();
            int step = start < end ? 1 : -1;

            for (int i = start; i < end; i+=step){
                swapTokens(new BoardSize(height, i), new BoardSize(height, i+step));
            }
        }
    }

    private int getIndexFromLocation(BoardSize location) {
        return location.getHeight() * size.getWidth() + location.getWidth();
    }

    public boolean areAdjacent(BoardSize pos1, BoardSize pos2) {
        //     0  1   2   3
        //   |-------------
        // 0 | 0,  1,  2,  3
        // 1 | 4,  5,  6,  7
        // 2 | 8,  9,  10, 11
        // 3 | 12, 13, 14, 15

        int width1 = pos1.getWidth();
        int width2 = pos2.getWidth();

        int height1 = pos1.getHeight();
        int height2 = pos2.getHeight();

        if (width1 == width2) {
            return height1 == height2 + 1 || height2 == height1 + 1;
        }

        if (height1 == height2) {
            return width1 == width2 + 1 || width2 == width1 + 1;
        }

        return false;
    }

    public boolean areInLine(BoardSize pos1, BoardSize pos2) {
        int width1 = pos1.getWidth();
        int width2 = pos2.getWidth();

        int height1 = pos1.getHeight();
        int height2 = pos2.getHeight();

        boolean sameWidth = width1 == width2;
        boolean sameHeight = height1 == height2;

        return sameWidth ^ sameHeight;
    }

    public Iterable<Token> tokens() {
        return () -> tokens.iterator();
    }
}
