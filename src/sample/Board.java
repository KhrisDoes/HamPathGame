package sample;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Board{


    private Scene scene;


    public Board(double width, double height){

        Group root = initializeBoard(width, height);

        scene = new Scene(root, width, height, Paint.valueOf("RED"));



    }

    public Group initializeBoard(double width, double height){


        Group root = new Group();

        int numberOfTilesHorizontal = (int) (width / 50);
        int numberOfTilesVertical = (int) (height / 50);

        for(int j = 0; j < numberOfTilesHorizontal; j++){


            for(int i = 0; i < numberOfTilesVertical; i++){

                if (j == 3 ) {
                    root.getChildren().add(new Tile(j * 50, i * 50, 50, 50, Color.BLUE, Color.BLACK));

                }

                    root.getChildren().add(new Tile(j * 50, i * 50, 50, 50, Color.YELLOW, Color.BLACK));
                }

            }



        return root;

    }

    public Scene getScene() {
        return scene;
    }
}
