package au.com.arvis;

import au.com.arvis.business.CommandParser;
import au.com.arvis.business.Simulator;
import au.com.arvis.model.Command;
import au.com.arvis.model.Robot;
import au.com.arvis.model.Table;

import java.util.List;

public class Main {

    public static void main(String[] args) {

       if(args != null && args.length > 0){

           try {

               for(int i = 0; i < args.length; i ++){

                   String testFile = args[i];

                   System.out.println("Starting simulation file: "+ testFile);

                   List<Command> commandList = CommandParser.getCommands(args[i]);

                   Simulator simulator = new ToyRobotSimulator();

                   simulator.setRobot(new Robot());

                   simulator.setTable(new Table(5, 5));

                   simulator.setCommand(commandList);

                   simulator.run();

               }



           } catch (Exception e) {

               System.out.println("Invalid command file: "+ e.getMessage());
           }

       }else{

           System.out.println("No command file has been specified.");

       }



    }


}
