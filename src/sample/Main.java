package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    // Level 1
    public static final int BOARD_WIDTH = 450;
    public static final int BOARD_HEIGHT = 600;
    public static final Position GOAL_POSITION = new Position(2,5);


    // Level 2
    public static final int BOARD_WIDTH_2 = 600;
    public static final int BOARD_HEIGHT_2 = 850;
    public static final Position GOAL_POSITION_2 = new Position(5,7);

    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("HamPathGame");
        Board myBoard = new Board( BOARD_WIDTH, BOARD_HEIGHT, GOAL_POSITION);


        primaryStage.setScene(myBoard.getScene());
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
