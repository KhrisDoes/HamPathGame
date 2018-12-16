package sample;


// Struct-like class
public class Position {


    public int xPosition;
    public int yPosition;

    public Position(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public String toString() {
        return "Current position: (" + xPosition + ", " + yPosition + ")";
    }
}
