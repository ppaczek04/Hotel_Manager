package org.example.lab.agh;

import org.example.lab.agh.command_package.*;
import org.example.lab.agh.model_package.Hotel;

import java.util.Scanner;

/**
 * Factory class responsible for creating {@link Command} objects based on user input.
 */
public class CommandFactory {

    /**
     * Returns a specific {@link Command} object based on the provided user input.
     *
     * @param userInput   the command input from the user
     * @param hotel       the {@link Hotel} instance to be used in the command
     * @param mainScanner the {@link Scanner} instance for user input in commands
     * @return a specific {@link Command} object corresponding to the user input
     */
    public Command getCommand(String userInput, Hotel hotel, Scanner mainScanner){
        switch(userInput) {
            case "prices":
                return new PricesCommand(hotel);
            case "view":
                return new ViewCommand(hotel, mainScanner);
            case "checkin":
                return new CheckinCommand(hotel, mainScanner);
            case "checkout":
                return new CheckoutCommand(hotel, mainScanner);
            case "list":
                return new ListCommand(hotel);
            case "save":
                return new SaveCommand(hotel);
            case "exit":
                return new ExitCommand();
            default:
                return new UnknownCommand(); // Obsługa nieznanych komend
        }
    }
}
