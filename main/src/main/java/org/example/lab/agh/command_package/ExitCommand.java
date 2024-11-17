package org.example.lab.agh.command_package;

/**
 * The {@code ExitCommand} class implements the {@code Command} interface
 * and provides functionality for exiting the application.
 * <p>
 * When executed, this command displays a farewell message and signals
 * the end of the application's main loop.
 * </p>
 */
public class ExitCommand implements Command{

    /**
     * Executes the exit command by displaying a farewell message to the user.
     * <p>
     * This method outputs a decorative message thanking the user for using the application.
     * </p>
     */
    public void execute(){
        System.out.println("************************************************");
        System.out.println("******** Thank you for using our App !! ********");
        System.out.println("************************************************");
    }
}