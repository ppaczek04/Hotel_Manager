package org.example.lab.agh.command_package;


/**
 * Represents a command that can be executed.
 * <p>
 * This interface is part of the Command design pattern and provides a common
 * method for all concrete command implementations to execute their respective logic.
 * </p>
 */
public interface Command {

    /**
     * Executes the command's specific logic.
     * <p>
     * This method is invoked to perform the operation defined by a concrete command implementation.
     * </p>
     */
    void execute();
}
