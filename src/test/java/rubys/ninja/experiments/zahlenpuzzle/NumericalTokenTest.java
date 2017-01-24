package rubys.ninja.experiments.zahlenpuzzle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Ruben Schmidmeister (bash)
 */
public class NumericalTokenTest {

    @Test
    public void testValueWorks() {
        NumericalToken token = new NumericalToken(1);

        assertEquals(1, token.getValue());
    }

}
