package org.example.lab.agh.command_package;

/**
 * The {@code UnknownCommand} class implements the {@code Command} interface
 * and handles cases where an unrecognized command is entered.
 */
public class UnknownCommand implements  Command{

    /**
     * Executes the command by displaying a message indicating an unknown command.
     * <p>
     * This method is invoked when the user inputs a command that is not recognized
     * by the system. It provides a prompt suggesting a potential typo.
     * </p>
     */
    public void execute(){
        System.out.println("Unknown command, maybe typo??");
    }
}
