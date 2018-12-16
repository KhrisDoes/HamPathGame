package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.shape.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Rectangle r = new Rectangle();
        r.setX(150);
        r.setY(150);
        r.setWidth(100);
        r.setHeight(100);
        r.setFill(Paint.valueOf("YELLOW"));

        Group myRoot = new Group();
        Scene myScene = new Scene(myRoot, 300, 275);

        myRoot.getChildren().add(r);
        myScene.setFill(Paint.valueOf("RED"));
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
