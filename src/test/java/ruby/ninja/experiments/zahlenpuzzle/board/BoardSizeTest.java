package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;

import static org.junit.Assert.*;

public class BoardSizeTest {
    private BoardSize size;

    @Before
    public void setup() throws Exception {
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
    public void testZeroWidth() throws Exception {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getWidth());
    }

    @Test
    public void testZeroHeight() throws Exception {
        BoardSize zeroBoardSize = new BoardSize(0, 0);
        assertSame(0, zeroBoardSize.getHeight());
    }

    @Test(expected = Exception.class)
    public void testNegativeWidth() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(-3, 3);
    }

    @Test(expected = Exception.class)
    public void testNegativeHeight() throws Exception {
        BoardSize negativeBoardSize = new BoardSize(0, -3);
    }

    @Test
    public void testEquals() throws Exception {
        BoardSize boardSize = new BoardSize(1, 2);

        assertTrue(boardSize.equals(new BoardSize(1, 2)));
        assertFalse(boardSize.equals(new BoardSize(2, 1)));
    }

    @Test
    public void testToString() throws Exception {
        BoardSize boardSize = new BoardSize(0, 0);

        assertEquals("(0, 0)", boardSize.toString());
    }
}
