package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruben Schmidmeister (bash)
 */
public class HardcodedInitializer implements BoardInitializer {
    public List<Token> getTokens() {
        return new ArrayList<Token>() {{
           add(new NumericalToken(15));
           add(new NumericalToken(4));
           add(new NumericalToken(1));
           add(new NumericalToken(6));
           add(new NumericalToken(3));
           add(new NumericalToken(8));
           add(new NumericalToken(5));
           add(new NumericalToken(10));
           add(new NumericalToken(7));
           add(new NumericalToken(12));
           add(new NumericalToken(9));
           add(new NumericalToken(14));
           add(new NumericalToken(11));
           add(new EmptyToken());
           add(new NumericalToken(13));
           add(new NumericalToken(2));
        }};
    }

    public BoardSize getBoardSize() {
        return new BoardSize(4, 4);
    }
}
