package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.control.Button;



public class Board{


    private Scene scene;

    private BorderPane border;
    private Tile[][] board;
    private HBox topHbox;

    private int numberOfTilesHorizontal;
    private int numberOfTilesVertical;

    private Controller controller;

    private Position goal;
    private Position start;


    public Board(double width, double height, Position goal){

        this.goal = goal;

        numberOfTilesHorizontal = (int) (width / 50);
        numberOfTilesVertical = (int) (height/ 50);
        start = new Position(numberOfTilesHorizontal / 2, 0);

//        topHbox = new HBox();
//        initHbox();



        controller = new Controller(this, goal);
        board = new Tile[numberOfTilesHorizontal][numberOfTilesVertical];


        border = new BorderPane();

        border.setCenter(initializeBoard());
//        border.getCenter().addEventFilter(KeyEvent.ANY, keyListener);
        // border.setTop(topHbox);

        scene = new Scene(border, width, height, Paint.valueOf("RED"));
        scene.setOnKeyPressed(keyListener);

    }

    /**
     * NOTE: - How to reset
     *       - Refactor to use controller
     *       https://stackoverflow.com/questions/36612724/javafx-event-handler-no-longer-working
     */


    public void initHbox(){
        Button reset = new Button("RETRY");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                resetScene();
            }
        });

        topHbox.getChildren().add(reset);

    }

    public void resetScene(){

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



        for(int j = 0; j < numberOfTilesHorizontal; j++){
            for(int i = 0; i < numberOfTilesVertical; i++){

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
