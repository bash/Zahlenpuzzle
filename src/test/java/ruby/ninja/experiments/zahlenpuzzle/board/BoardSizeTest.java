package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

import static org.junit.Assert.*;

public class BoardSizeTest {
    private BoardSize size;

    @Before
    public void setup() throws BoardSize.InvalidValueException {
        size = new BoardSize(4, 52);
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
    public void testZeroWidth() throws BoardSize.InvalidValueException {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getWidth());
    }

    @Test
    public void testZeroHeight() throws BoardSize.InvalidValueException {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getHeight());
    }

    @Test(expected = BoardSize.InvalidValueException.class)
    public void testNegativeWidth() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(-3, 3);
    }

    @Test(expected = BoardSize.InvalidValueException.class)
    public void testNegativeHeight() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(0, -3);
    }

    @Test
    public void testEquals() throws BoardSize.InvalidValueException {
        BoardSize boardSize = new BoardSize(1, 2);
        assertTrue(boardSize.equals(new BoardSize(1, 2)));
    }

    @Test
    public void testNotEquals() throws BoardSize.InvalidValueException {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(new BoardSize(2, 1)));
    }

    @Test
    public void testNotEqualsSame() throws BoardSize.InvalidValueException {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(boardSize));
    }

    @Test
    public void testNotEqualsNull() throws BoardSize.InvalidValueException {
        BoardSize boardSize = new BoardSize(1, 2);
        assertFalse(boardSize.equals(null));
    }


    @Test
    public void testToString() throws BoardSize.InvalidValueException {
        BoardSize boardSize = new BoardSize(0, 0);

        assertEquals("(0, 0)", boardSize.toString());
    }
}
