package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class BoardTest {
    private Board board;

    @Before
    public void setup() throws Exception {
        board = new Board(new BoardSize(4, 5));
    }

    @Test
    public void TestGetSize() throws Exception {
        assertEquals(new BoardSize(4, 5), board.getSize());
    }

    @Test
    public void TestGetToken() throws Exception {
        Token token = board.getTokenAt(new BoardSize(3, 3));
        assertNotNull(token);
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
}
