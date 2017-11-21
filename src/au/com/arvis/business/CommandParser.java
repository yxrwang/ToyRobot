package au.com.arvis.business;

import au.com.arvis.model.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 21/11/17.
 */
public class CommandParser {

    private static final String SPACE = " ";

    private static final String COMMA = ",";

    public static List<Command> getCommands(String fileName) throws Exception {

        List<Command> commands = new ArrayList<>();

        File commandFile = new File(fileName);

        BufferedReader fileReader = new BufferedReader(new FileReader(commandFile));

        String command = fileReader.readLine();

        while (command != null) {

            if (command.startsWith(Operation.PLACE.name())) {

                commands.add(parsePlaceCommand(command));

            } else {

                try {

                    commands.add(parseNonArgumentsCommand(command));

                } catch (IllegalArgumentException e) {

                    System.out.println("Skipped parsing the invalid command: "+ command);

                }

            }

            command = fileReader.readLine();
        }

        return commands;
    }

    private static Command parsePlaceCommand(String command) {

        Command placeCommand = new Command(Operation.PLACE);

        placeCommand.setArgument(new Position(0, 0));

        String[] commandWithArgs = command.split(SPACE);

        try {

            Operation operation = Operation.valueOf(commandWithArgs[0]);

            placeCommand.setOperation(operation);

            if (commandWithArgs.length == 2) {

                String[] placeArgs = commandWithArgs[1].split(COMMA);

                if (placeArgs.length == 3) {

                    Position position = new Position(Integer.parseInt(placeArgs[0]), Integer.parseInt(placeArgs[1]));

                    Facing facing = Facing.valueOf(placeArgs[2]);

                    placeCommand.setArgument(new PlaceOperationArgument(position, facing));

                }
            }

        } catch (Exception e) {

            System.out.print("Invalid Place command: " + e.getMessage());
        }

        return placeCommand;
    }

    private static Command parseNonArgumentsCommand(String command) throws IllegalArgumentException {

        return new Command(Operation.valueOf(command));
    }
}
