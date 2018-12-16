package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class WinPane {

    private BorderPane pane;
    private Button exitButton;
    private String style;


    public WinPane(){

        pane = new BorderPane();
        style = "-fx-background-color: rgba(255, 255, 255, 0.5);";


        exitButton = new Button("YOU WON");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        pane.setCenter(exitButton);
        pane.setStyle(style);



    }

    public Pane getPane() {
        return pane;
    }



}
