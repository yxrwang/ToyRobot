package au.com.arvis.business;

import au.com.arvis.model.Command;
import au.com.arvis.model.Robot;
import au.com.arvis.model.Table;

import java.util.List;

/**
 * Created by Jack on 21/11/17.
 */
public interface Simulator {

    void report();

    void setCommand(List<Command> commands);

    void run();

    void setRobot(Robot robot);

    void setTable(Table table);
}
