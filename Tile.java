/**
 * Created by josephmolina on 6/13/17.
 */
public class Tile {

    private int numBombsNearBy;
    private String faceUp;
    private boolean isBomb;

    public Tile(){
        numBombsNearBy = 0;
        faceUp = "X";
        isBomb = false;
    }

    public Tile(int numBombsNearBy, String faceUp, boolean isBomb){
        this.numBombsNearBy = numBombsNearBy;
        this.faceUp = faceUp;
        this.isBomb = isBomb;
    }

    public int getNumBombsNearBy() {
        return numBombsNearBy;
    }

    public void setNumBombsNearBy(int numBombsNearBy) {
        this.numBombsNearBy = numBombsNearBy;
    }

    public String getFaceUp() {
        return faceUp;
    }

    public void setFaceUp(String faceUp) {
        this.faceUp = faceUp;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public String toString(){
        return(faceUp);
    }
}
