package au.com.arvis.model;

/**
 * Created by Jack on 21/11/17.
 */
public class Command {

    private Operation operation;

    private Object argument;

    public Command(Operation operation){

        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
