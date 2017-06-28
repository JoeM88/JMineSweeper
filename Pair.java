import java.util.Objects;

/**
 * Created by josephmolina on 6/25/17.
 */
public class Pair{

    private  int x;
    private int y;

    public Pair(){
        x = 0;
        y = 0;
    }

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return  y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }




}