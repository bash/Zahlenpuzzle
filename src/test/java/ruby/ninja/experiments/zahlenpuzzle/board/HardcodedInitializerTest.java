package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.HardcodedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ruben Schmidmeister (bash)
 */
public class HardcodedInitializerTest {
    @Test
    public void testInitializer() throws Exception {
        HardcodedInitializer initializer = new HardcodedInitializer();

        List<Token> tokens = initializer.getTokens();

        assertNumericalToken(tokens.get(0), 15);
        assertNumericalToken(tokens.get(1), 4);
        assertNumericalToken(tokens.get(2), 1);
        assertNumericalToken(tokens.get(3), 6);
        assertNumericalToken(tokens.get(4), 3);
        assertNumericalToken(tokens.get(5), 8);
        assertNumericalToken(tokens.get(6), 5);
        assertNumericalToken(tokens.get(7), 10);
        assertNumericalToken(tokens.get(8), 7);
        assertNumericalToken(tokens.get(9), 12);
        assertNumericalToken(tokens.get(10), 9);
        assertNumericalToken(tokens.get(11), 14);
        assertNumericalToken(tokens.get(12), 11);
        assertTrue(tokens.get(13) instanceof EmptyToken);
        assertNumericalToken(tokens.get(14), 13);
        assertNumericalToken(tokens.get(15), 2);

        assertEquals(new BoardSize(4, 4), initializer.getBoardSize());
    }

    private void assertNumericalToken(Token token, Integer value) {
        assertTrue(token instanceof NumericalToken);
        assertSame(value, ((NumericalToken) token).getValue());
    }
}
