package sample;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public class Controller {


    private  Position currentPosition;
    private  Board board;


    public Controller(Board board){

        this.board = board;
        currentPosition = new Position(board.getNumberOfTilesHorizontal() / 2, 0);
        System.out.println(currentPosition);


    }

    public boolean checkPreviousTile(int xPosition, int yPosition){
        return board.getTile(xPosition, yPosition).getFill() == Color.YELLOW;
    }


    public  void moveLeft(){
        if(currentPosition.xPosition != 0 && checkPreviousTile(currentPosition.xPosition - 1, currentPosition.yPosition)){
            currentPosition.xPosition -= 1;
        }
        updateBoard();

    }


    public  void moveRight(){
        if(currentPosition.xPosition != (board.getNumberOfTilesHorizontal() - 1)  && checkPreviousTile(currentPosition.xPosition + 1, currentPosition.yPosition)){
            currentPosition.xPosition += 1;
        }
        updateBoard();
    }

    public  void moveUp(){
        if(currentPosition.yPosition != 0 && checkPreviousTile(currentPosition.xPosition, currentPosition.yPosition - 1)){
            currentPosition.yPosition -= 1;
        }
        updateBoard();
    }

    public  void moveDown(){
        if(currentPosition.yPosition != (board.getNumberOfTilesVertical() - 1)  && checkPreviousTile(currentPosition.xPosition, currentPosition.yPosition + 1) ){
            currentPosition.yPosition += 1;
            updateBoard();
        }
    }

    private  void updateBoard(){

        board.updateBoard(currentPosition.xPosition, currentPosition.yPosition, Color.RED);
    }


}
