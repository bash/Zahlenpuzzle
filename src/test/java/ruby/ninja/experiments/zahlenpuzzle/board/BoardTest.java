package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardInitializer;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

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
        assertAdjacent(new BoardSize(2, 2), new BoardSize(2, 0), true);
    }

    @Test
    public void testAreNotAdjacentRight() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(2, 4), true);
    }

    @Test
    public void testAreNotAdjacentDown() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(0, 2), true);
    }

    @Test
    public void testAreNotAdjacentLeft() throws Exception {
        assertAdjacent(new BoardSize(2, 2), new BoardSize(4, 2), true);
    }


    @Test
    public void testAreNotAdjacentDiagonally() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(2, 2), false);
    }

    @Test
    public void testAreNotAdjacentWhenSame() throws Exception {
        assertAdjacent(new BoardSize(1, 1), new BoardSize(1, 1), false);
    }

    private void assertAdjacent(BoardSize pos1, BoardSize pos2, boolean expected) {
        assertSame(expected, board.areAdjacent(pos1, pos2));
    }
}
