package ruby.ninja.experiments.zahlenpuzzle.token;

import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import static org.junit.Assert.assertSame;

public class EmptyTokenTest {
    @Test
    public void testInstantiationWorks() {
        Token token = new EmptyToken();
    }
}
