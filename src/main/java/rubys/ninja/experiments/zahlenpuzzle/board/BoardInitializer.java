package rubys.ninja.experiments.zahlenpuzzle.board;

import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.List;

public interface BoardInitializer {
    List<Token> getTokens();

    BoardSize getBoardSize();
}
