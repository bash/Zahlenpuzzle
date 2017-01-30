package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.List;


public class SortedInitializer implements BoardInitializer {

    private BoardSize size;

    public SortedInitializer(BoardSize size) {
        this.size = size;
    }

    public List<Token> getTokens() {
        List<Token> tokens = new ArrayList<>();

        for (int i = 1; i < size.getHeight() * size.getWidth(); i++)
            tokens.add(new NumericalToken(i));
        tokens.add(new EmptyToken());

        return tokens;
    }

    public BoardSize getBoardSize() {
        return size;
    }
}
