package au.com.arvis.model;

/**
 * Created by Jack on 21/11/17.
 */
public class Position {

    private int x;

    private int y;

    public Position(int x, int y){

        this.x = x;

        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
