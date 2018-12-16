package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {



    public Tile(double x, double y, double width, double height, Color color, Color stroke) {
        super.setX(x);
        super.setY(y);
        super.setWidth(width);
        super.setHeight(height);
        super.setFill(color);
        super.setStroke(stroke);
    }

}
