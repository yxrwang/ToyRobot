package au.com.arvis.business;

import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.Facing;
import au.com.arvis.model.Position;
import au.com.arvis.model.Table;

/**
 * Created by Jack on 21/11/17.
 */
public interface RobotOperation {

    void turnLeft();

    void turnRight();

    void place(Position position, Facing facing, Table table) throws InvalidPosition;

    void move(Table table) throws InvalidPosition;
}
