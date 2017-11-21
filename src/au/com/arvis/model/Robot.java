package au.com.arvis.model;

import au.com.arvis.business.RobotOperation;
import au.com.arvis.exception.InvalidPosition;

/**
 * Created by Jack on 21/11/17.
 */
public class Robot implements RobotOperation{

    private Position currentPosition = new Position(0,0);

    private Facing currentFacing = Facing.NORTH;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Facing getCurrentFacing() {
        return currentFacing;
    }

    public void setCurrentFacing(Facing currentFacing) {
        this.currentFacing = currentFacing;
    }

    @Override
    public void turnLeft() {

        currentFacing = Facing.getFacing(currentFacing.getValue() - 90);
    }

    @Override
    public void turnRight() {

        currentFacing = Facing.getFacing(currentFacing.getValue() + 90);
    }

    @Override
    public void place(Position position, Facing facing,Table table) throws InvalidPosition{

        if(facing != null){

            currentFacing = facing;
        }

        if(position.getX() < 0 || position.getY() < 0 || position.getX() > table.getWidth() || position.getY() > table.getHeight()){

            throw new InvalidPosition();
        }


        currentPosition = position;
    }

    @Override
    public void move(Table table) throws InvalidPosition {

        Position destination = null;

        switch (currentFacing){

            case EAST:
                destination = new Position(currentPosition.getX()+1, currentPosition.getY());
                break;
            case WEST:
                destination = new Position(currentPosition.getX()-1, currentPosition.getY());
                break;
            case SOUTH:
                destination = new Position(currentPosition.getX(), currentPosition.getY() - 1);
                break;
            case NORTH:
                destination = new Position(currentPosition.getX(), currentPosition.getY() + 1);
                break;
        }

        place(destination, currentFacing,table);
    }
}
