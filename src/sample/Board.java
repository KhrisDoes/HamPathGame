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

    private Position goal;
    private Position start;


    public Board(double width, double height, Position goal){

        numberOfTilesHorizontal = (int) (width / 50);
        numberOfTilesVertical = (int) (height/ 50);
        start = new Position(numberOfTilesHorizontal / 2, 0);

        this.goal = goal;

        controller = new Controller(this, goal);

        board = new Tile[numberOfTilesHorizontal][numberOfTilesVertical];

        Group root = initializeBoard();

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


    public Group initializeBoard(){


        Group root = new Group();



        for(int j = 0; j < numberOfTilesVertical; j++){
            for(int i = 0; i < numberOfTilesHorizontal; i++){

                if (j == goal.xPosition && i == goal.yPosition) {
                    board[j][i] = new Tile(j * 50, i * 50, 50, 50, Color.RED, Color.BLACK);
                }else if(j == start.xPosition && i == 0) {
                    board[j][i] = new Tile(j * 50, i * 50, 50, 50, Color.RED, Color.BLACK);
                }else{
                    board[j][i] = new Tile(j * 50, i * 50, 50, 50, Color.YELLOW, Color.BLACK);
                }

            }

        }

        board[goal.xPosition][goal.yPosition].setFill(Color.GREEN);

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

    public int getNumberOfTiles(){
        return numberOfTilesHorizontal * numberOfTilesVertical;
    }
}
