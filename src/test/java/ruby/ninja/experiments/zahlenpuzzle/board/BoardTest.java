package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardInitializer;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.SortedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setup() throws Exception {
        board = new Board(new MockInitializer());
    }

    @Test
    public void TestGetSize() throws Exception {
        assertEquals(new BoardSize(2, 2), board.getSize());
    }

    @Test
    public void TestGetToken() throws Exception {
        board.getTokenAt(new BoardSize(1, 0));
    }

    @Test
    public void testGetTokenAtIndex() throws Exception {
        board.getTokenAt(0);
    }

    @Test(expected = Exception.class)
    public void TestBounds() throws Exception {
        Token token = board.getTokenAt(new BoardSize(5, 6));
    }

    @Test
    public void TestSwapWithPos() throws Exception {
        BoardSize pos1 = new BoardSize(0, 0);
        BoardSize pos2 = new BoardSize(0, 1);

        Token oldToken1 = board.getTokenAt(pos1);
        Token oldToken2 = board.getTokenAt(pos2);

        board.swapTokens(pos1, pos2);

        Token newToken1 = board.getTokenAt(pos1);
        Token newToken2 = board.getTokenAt(pos2);

        assertSame(oldToken1, newToken2);
        assertSame(oldToken2, newToken1);
    }

    @Test
    public void TestMoveInLine() throws Exception {
        Board sorted = new Board(new SortedInitializer(new BoardSize(3, 3)));
        BoardSize pos1 = new BoardSize(2, 2);
        BoardSize pos2 = new BoardSize(1, 2);
        BoardSize pos3 = new BoardSize(0, 2);

        Token oldToken1 = sorted.getTokenAt(pos1);
        Token oldToken2 = sorted.getTokenAt(pos2);
        Token oldToken3 = sorted.getTokenAt(pos3);

        sorted.moveTokensInLine(pos1, pos3);

        Token newToken1 = sorted.getTokenAt(pos1);
        Token newToken2 = sorted.getTokenAt(pos2);
        Token newToken3 = sorted.getTokenAt(pos3);

        assertSame(oldToken1, newToken3);
        assertSame(oldToken3, newToken2);
        assertSame(oldToken2, newToken1);
    }

    @Test
    public void testAreAdjacentUp() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(1, 0), true);
    }

    @Test
    public void testAreAdjacentRight() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(2, 1), true);
    }

    @Test
    public void testAreAdjacentDown() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(1, 2), true);
    }

    @Test
    public void testAreAdjacentLeft() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(0, 1), true);
    }

    @Test
    public void testAreNotAdjacentUp() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(2, 0), false);
    }

    @Test
    public void testAreNotAdjacentRight() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(2, 4), false);
    }

    @Test
    public void testAreNotAdjacentDown() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(0, 2), false);
    }

    @Test
    public void testAreNotAdjacentLeft() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(4, 2), false);
    }

    @Test
    public void testAreNotAdjacentDiagonally() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(2, 2), false);
    }

    @Test
    public void testAreNotAdjacentWhenSame() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(1, 1), false);
    }

    @Test
    public void testIterator() {
        BoardSize boardSize = board.getSize();
        Iterator<Token> iterator = board.tokens().iterator();

        for (int i = 0; i < boardSize.getHeight(); i++) {
            for (int j = 0; j < boardSize.getWidth(); j++) {
                Token expected = board.getTokenAt(new BoardSize(j, i));
                Token actual = iterator.next();

                assertSame(expected, actual);
            }
        }
    }

    private void assertAdjacent(BoardSize pos1, BoardSize pos2, boolean expected) {
        assertSame(expected, board.areAdjacent(pos1, pos2));
    }

    private class MockToken implements Token {
    }

    private class MockInitializer implements BoardInitializer {
        public List<Token> getTokens() {
            return new ArrayList<Token>() {{
                add(new MockToken());
                add(new MockToken());
                add(new MockToken());
                add(new MockToken());
            }};
        }

        public BoardSize getBoardSize() {
            try {
                return new BoardSize(2, 2);
            } catch (Exception ignored) {
                fail();
                return null;
            }
        }
    }
}
