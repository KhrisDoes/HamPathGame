package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile {

    private Rectangle rectangle;
    private double width = 50;
    private double xPos;
    private double yPos;


    public Tile(double width, double xPos, double yPos, Paint paint, Group root){

        this.width = width;
        this.xPos = xPos;
        this.yPos = yPos;

        rectangle = new Rectangle(xPos, yPos, width, width);
        rectangle.setFill(paint);

        root.getChildren().add(rectangle);

    }


}
