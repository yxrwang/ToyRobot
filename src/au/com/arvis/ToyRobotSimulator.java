package au.com.arvis;

import au.com.arvis.business.Simulator;
import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 21/11/17.
 */
public class ToyRobotSimulator implements Simulator{

    private Robot robot = new Robot();

    private List<Command> commands = new ArrayList<>();

    private Table table = new Table(5,5);

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public void report() {

        Position currentPosition = robot.getCurrentPosition();

        Facing currentFacing = robot.getCurrentFacing();

        System.out.println(currentPosition.getX()+", "+currentPosition.getY() + ", "+ currentFacing.name());
    }

    @Override
    public void setCommand(List<Command> commands) {

        this.commands = commands;
    }

    @Override
    public void run() {


        if(!commands.isEmpty()){

            for(Command command : commands){

                switch (command.getOperation()){

                    case RIGHT:

                        robot.turnRight();

                        break;


                    case LEFT:

                        robot.turnLeft();

                        break;

                    case MOVE:

                        try{

                            robot.move(table);

                        }catch (InvalidPosition e){

                            System.out.println("The robot is going to fall off the table, ignore this move.");
                        }


                        break;

                    case PLACE:

                        try {

                            PlaceOperationArgument argument = (PlaceOperationArgument)command.getArgument();

                            if(argument != null){

                                robot.place(argument.getPosition(), argument.getFacing(), table);
                            }


                        }catch (InvalidPosition e){

                            System.out.println("The robot will fall off the table, ignore the position.");
                        }

                        break;

                    case REPORT:

                        report();

                        break;

                    default:
                        break;
                }
            }

        }else{

            System.out.print("No command has been given to the Robot.");
        }
    }
}
