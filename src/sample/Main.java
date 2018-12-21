package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class Main extends Application {

    public static final int BOARD_WIDTH = 450;
    public static final int BOARD_HEIGHT = 600;
    public static final Position GOAL_POSITION = new Position(2,5);


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        SceneManager.addScreen("win", new WinPane().getPane());

        primaryStage.setTitle("HamPathGame");
        Board myBoard = new Board( BOARD_WIDTH, BOARD_HEIGHT, GOAL_POSITION);

        primaryStage.setScene(myBoard.getScene());
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
