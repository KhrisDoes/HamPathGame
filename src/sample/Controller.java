package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Controller {


    private  Position currentPosition;
    private Position initialPosition;
    private Position goalPosition;
    private  Board board;
    private int counter; // number of moves = number of tiles covered


    public Controller(Board board, Position goalPosition){

        this.board = board;
        this.goalPosition = goalPosition;
        this.initialPosition = new Position(board.getNumberOfTilesHorizontal() / 2, 0);
        currentPosition = initialPosition;
        counter = 0;


    }

    public boolean checkPreviousTile(int xPosition, int yPosition){
        return board.getTile(xPosition, yPosition).getFill() == Color.YELLOW;
    }


    public boolean hasWon(){
        return nextToGoal() && counter == board.getNumberOfTiles() - 2;
    }

    public boolean nextToGoal(){
        return Math.abs(currentPosition.xPosition - goalPosition.xPosition) == 1 || // If next to goal on the x-axis
               Math.abs(currentPosition.yPosition - goalPosition.yPosition) == 1;   // or next to goal on the y-axis
    }

    public  void moveLeft(){
        if(currentPosition.xPosition != 0 && checkPreviousTile(currentPosition.xPosition - 1, currentPosition.yPosition)){
            currentPosition.xPosition -= 1;
            updateBoard();
            counter++;

            if(hasWon()){

                board.getScene().setRoot(new WinPane().getPane());
            }

        }


    }


    public  void moveRight(){
        if(currentPosition.xPosition != (board.getNumberOfTilesHorizontal() - 1)  && checkPreviousTile(currentPosition.xPosition + 1, currentPosition.yPosition)){
            currentPosition.xPosition += 1;

            updateBoard();
            counter++;

            if(hasWon()){
                board.getScene().setRoot(new WinPane().getPane());
            }

        }


    }

    public  void moveUp(){

        if(currentPosition.yPosition != 0 && checkPreviousTile(currentPosition.xPosition, currentPosition.yPosition - 1)){
            currentPosition.yPosition -= 1;
            updateBoard();
            counter++;
            if(hasWon()){
                board.getScene().setRoot(new WinPane().getPane());
            }

        }



    }

    public  void moveDown(){

        if(currentPosition.yPosition != (board.getNumberOfTilesVertical() - 1)  && checkPreviousTile(currentPosition.xPosition, currentPosition.yPosition + 1) ){
            currentPosition.yPosition += 1;
            updateBoard();
            counter++;

            if(hasWon()){
                board.getScene().setRoot(new WinPane().getPane());
            }
        }
    }

    private  void updateBoard(){

        board.updateBoard(currentPosition.xPosition, currentPosition.yPosition, Color.RED);
    }

    public void resetPosition(){

        currentPosition.xPosition = board.getNumberOfTilesHorizontal() / 2;
        currentPosition.yPosition = 0;
        counter = 0;
    }



    public void setCurrentPosition(Position position){
        this.currentPosition = position;
    }


}
