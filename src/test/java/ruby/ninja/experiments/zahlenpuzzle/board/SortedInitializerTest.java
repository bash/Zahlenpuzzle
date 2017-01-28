package ruby.ninja.experiments.zahlenpuzzle.board;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardInitializer;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.SortedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class SortedInitializerTest {
    BoardInitializer init;
    @Before
    public void setup() {
        init = new SortedInitializer(new BoardSize(4,4));
    }

    @Test
    public void TestTokens() {
        List<Token> tokens = init.getTokens();
        for (int i = 0; i < tokens.size() - 1; i++) {
            assertNumericalToken(tokens.get(i), i);
        }
        assertTrue(tokens.get(tokens.size() - 1) instanceof EmptyToken);
    }

    private void assertNumericalToken(Token token, Integer value) {
        assertTrue(token instanceof NumericalToken);
        assertSame(value, ((NumericalToken) token).getValue());
    }

    @Test
    public void TestSize() {
        assertTrue(init.getBoardSize().equals(new BoardSize(4,4)));
    }
}
