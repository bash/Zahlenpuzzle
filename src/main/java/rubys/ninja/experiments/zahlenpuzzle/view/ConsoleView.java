package rubys.ninja.experiments.zahlenpuzzle.view;

import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.game.Game;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleView {
    public void run() {
        DirectionController directionController = new DirectionController(this::getDirection);
        Board board = directionController.getBoard();

        clearScreen();
        System.out.println("Hi there, nice to meet you :-)");
        printBoard(board);

        while (true) {
            Game.UpdateResult result = directionController.update();

            clearScreen();

            switch (result) {
                case SuccessfulSwap:
                    printSomethingNice();
                    break;
                case RequestDenied:
                    System.out.println("Invalid move");
                    break;
                case GameFinished:
                    System.out.println("Congrats, you won!");
                    return;
            }

            printBoard(board);
        }
    }

    private void clearScreen() {
        for (int i = 0; i < 100; ++i) System.out.println();
    }

    private void printSomethingNice() {
        Random random = new Random();
        switch (random.nextInt(10)) {
            case 0:
                System.out.println("Nice moves my friend :)");
                break;
            case 1:
                System.out.println("Great Strategy!");
                break;
            case 2:
                System.out.println("Good movement, if I do say so myself");
                break;
            case 3:
                System.out.println("Good Job!");
                break;
            case 4:
                System.out.println("Excellent choice, good sir");
                break;
            case 5:
                System.out.println("Swaggy moves, dude!");
                break;
            case 6:
                System.out.println("Cool shizzle, my nizzle");
                break;
            case 7:
                System.out.println("omg :o");
                break;
            case 8:
                System.out.println("You can do it! :>");
                break;
            case 9:
                System.out.println("Meeeemes");
                break;
        }
    }

    private void printBoard(Board board) {
        System.out.println(renderBoard(board));
    }

    private String renderBoard(Board board) {
        StringBuilder builder = new StringBuilder();

        BoardSize size = board.getSize();
        List<String> tokens = getTokens(board);
        int cellWidth = getMaxWidth(tokens);
        int lineWidth = (cellWidth + 3) * size.getWidth();

        String divider = new String(new char[lineWidth]).replace("\0", "-") + "\n";

        builder.append(divider);

        for (int i = 0; i < size.getHeight(); i++) {
            builder.append("| ");

            for (int j = 0; j < size.getWidth(); j++) {
                Token token = board.getTokenAt(new BoardSize(j, i));

                builder.append(String.format("%-" + cellWidth + "s", token));
                builder.append(" | ");
            }

            builder.append("\n");
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

        for (Token token : board.tokens()) {
            tokens.add(token.toString());
        }

        return tokens;
    }


    private DirectionRequester.Direction getDirection() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Pick a direction [u/d/l/r]: ");

        String direction = reader.nextLine();

        switch (direction) {
            case "u":
                return DirectionRequester.Direction.up;
            case "d":
                return DirectionRequester.Direction.down;
            case "l":
                return DirectionRequester.Direction.left;
            case "r":
                return DirectionRequester.Direction.right;
        }

        return getDirection();
    }
}
