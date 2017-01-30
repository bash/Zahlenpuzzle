package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

import static org.junit.Assert.*;

public class BoardSizeTest {
    private BoardSize size;

    @Before
    public void setup() {
        try {
            size = new BoardSize(4, 52);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testWidth() {
        assertSame(4, size.getWidth());
    }

    @Test
    public void testHeight() {
        assertSame(52, size.getHeight());
    }

    @Test
    public void testZeroWidth() {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getWidth());
    }

    @Test
    public void testZeroHeight() {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getHeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(-3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeight() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(0, -3);
    }

    @Test
    public void testEquals() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertTrue(boardSize.equals(new BoardSize(1, 2)));
    }

    @Test
    public void testEqualsSame() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertTrue(boardSize.equals(boardSize));
    }

    @Test
    public void testNotEqualsWidth() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(new BoardSize(2, 2)));
    }

    @Test
    public void testNotEqualsHeitht() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(new BoardSize(1, 1)));
    }

    @Test
    public void testNotEqualsBoth() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(new BoardSize(2, 1)));
    }

    @Test
    public void testNotEqualsNull() {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(null));
    }


    @Test
    public void testToString() {
        BoardSize boardSize = new BoardSize(0, 0);

        assertEquals("(0, 0)", boardSize.toString());
    }
}
