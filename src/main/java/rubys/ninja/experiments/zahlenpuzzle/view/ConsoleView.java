package rubys.ninja.experiments.zahlenpuzzle.view;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.List;

public class ConsoleView {
    public void run() {
        DirectionController directionController = new DirectionController(() -> getDirection());
        Board board = directionController.getBoard();

        System.out.println(renderBoard(board));
    }

    private String renderBoard(Board board) {
        StringBuilder builder = new StringBuilder();

        BoardSize size = board.getSize();
        List<String> tokens = getTokens(board);
        int cellWidth = getMaxWidth(tokens);
        int lineWidth = cellWidth * size.getWidth();

        String divider = new String(new char[lineWidth]).replace("\0", "-");

        builder.append(divider);

        for (int i = 1; i < size.getHeight(); i++) {
            builder.append("|");

            for (int j = 1; j < size.getWidth(); j++) {
                Token token = board.getTokenAt(new BoardSize(j, i));

                builder.append(token);
                builder.append("|");
            }

            builder.append(divider);
        }

        return builder.toString();
    }

    private int getMaxWidth(List<String> strings) {
        int width = 0;

        for (String string : strings)
            if (string.length() > width)
                width = string.length();

        return width;
    }

    private List<String> getTokens(Board board) {
        ArrayList<String> tokens = new ArrayList<>();

        for (Token token : board) {
            tokens.add(token.toString());
        }

        return tokens;
    }


    public DirectionRequester.Direction getDirection() {
        return null;
    }
}
