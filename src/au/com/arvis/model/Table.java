package au.com.arvis.model;

/**
 * Created by Jack on 21/11/17.
 */
public class Table {

    private int width;

    private int height;

    public Table(int width, int height){

        this.width = width;

        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
