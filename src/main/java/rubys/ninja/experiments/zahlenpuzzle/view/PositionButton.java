package rubys.ninja.experiments.zahlenpuzzle.view;

import javafx.scene.control.Button;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

public class PositionButton extends Button {
    private BoardSize position;

    public PositionButton(BoardSize position, String text) {
        super(text);

        this.position = position;
    }

    public PositionButton(BoardSize position, Token token) {
        this(position, token.toString());
    }

    public BoardSize getPosition() {
        return position;
    }

    public void setToken(Token token) {
        setText(token.toString());
    }
}
