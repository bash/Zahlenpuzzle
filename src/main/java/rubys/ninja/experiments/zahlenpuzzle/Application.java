package rubys.ninja.experiments.zahlenpuzzle;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rubys.ninja.experiments.zahlenpuzzle.board.Board;
import rubys.ninja.experiments.zahlenpuzzle.board.BoardSize;
import rubys.ninja.experiments.zahlenpuzzle.board.HardcodedInitializer;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;
import rubys.ninja.experiments.zahlenpuzzle.view.PositionButton;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: get board from controller
        Board board = new Board(new HardcodedInitializer());

        BoardSize boardSize = board.getSize();

        VBox vbox = new VBox();
        vbox.setFillWidth(false);

        GridPane gridPane = new GridPane();
        vbox.getChildren().add(gridPane);

        for (int i = 0; i < boardSize.getHeight(); i++) {
            for (int j = 0; j < boardSize.getWidth(); j++) {
                BoardSize position = new BoardSize(j, i);
                Token token = board.getTokenAt(position);
                PositionButton button = new PositionButton(position, token);

                button.setOnAction(this::onButtonClick);

                gridPane.addRow(i, button);
            }
        }

        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add("/stylesheet.css");

        primaryStage.setTitle("Zahlenpuzzle");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
    }

    private void onButtonClick(ActionEvent event) {
        PositionButton button = (PositionButton) event.getSource();
        BoardSize position = button.getPosition();

        // TODO: pass position to controller
    }
}
