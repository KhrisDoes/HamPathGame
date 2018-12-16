package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Board{


    private Scene scene;

    private Tile[][] board;

    private int numberOfTilesHorizontal;
    private int numberOfTilesVertical;

    private Controller controller;


    public Board(double width, double height){

        numberOfTilesHorizontal = (int) (width / 50);
        numberOfTilesVertical = (int) (height/ 50);

        controller = new Controller(this);

        board = new Tile[numberOfTilesHorizontal][numberOfTilesVertical];

        Group root = initializeBoard(width, height);

        scene = new Scene(root, width, height, Paint.valueOf("RED"));
        scene.setOnKeyPressed(keyListener);

    }

    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if(keyEvent.getCode() == KeyCode.UP){
                controller.moveUp();
            }else if(keyEvent.getCode() == KeyCode.DOWN){
                controller.moveDown();
            }else if(keyEvent.getCode() == KeyCode.LEFT){
                controller.moveLeft();
            }else if(keyEvent.getCode() == KeyCode.RIGHT){
                controller.moveRight();
            }
            keyEvent.consume();
        }

    };

    private void addKeyListener(){

    }

    public Group initializeBoard(double width, double height){


        Group root = new Group();



        for(int j = 0; j < numberOfTilesVertical; j++){


            for(int i = 0; i < numberOfTilesHorizontal; i++){

                if (j == (int) (numberOfTilesHorizontal / 2) && i == 0) {
                    // root.getChildren().add(new Tile(j * 50, i * 50, 50, 50, Color.BLUE, Color.BLACK));
                    board[j][i] = new Tile(j * 50, i * 50, 50, 50, Color.RED, Color.BLACK);

                }else {

                    // root.getChildren().add(new Tile(j * 50, i * 50, 50, 50, Color.YELLOW, Color.BLACK));

                    board[j][i] = new Tile(j * 50, i * 50, 50, 50, Color.YELLOW, Color.BLACK);


                }
            }

        }

        board[3][4].setFill(Color.GREEN);
        addTilesToScene(root);


        return root;

    }

    public void addTilesToScene(Group root){
        for(int j = 0; j < board.length; j++){
            for(int i = 0; i < board[j].length; i++){
                root.getChildren().add(board[j][i]);
            }
        }
    }

    public Scene getScene() {
        return scene;
    }

    public int getNumberOfTilesHorizontal() {
        return numberOfTilesHorizontal;
    }

    public int getNumberOfTilesVertical() {
        return numberOfTilesVertical;
    }

    public void updateBoard(int x, int y, Color color){
        board[x][y].setFill(color);
    }

    public Tile getTile(int x, int y){
        return board[x][y];
    }
}
