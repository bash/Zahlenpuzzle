package ruby.ninja.experiments.zahlenpuzzle.token;

import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;

import static org.junit.Assert.assertSame;

public class NumericalTokenTest {
    @Test
    public void testValueWorks() {
        NumericalToken token = new NumericalToken(1);

        assertSame(1, token.getValue());
    }
}
