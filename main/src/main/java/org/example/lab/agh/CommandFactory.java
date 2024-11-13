package org.example.lab.agh;

import org.example.lab.agh.command_package.*;

public class CommandFactory {
    public Command getCommand(String userInput){
        switch(userInput) {
            case "prices":
                return new PricesCommand();
            case "view":
                return new ViewCommand();
            case "checkin":
                return new CheckinCommand();
            case "checkout":
                return new CheckoutCommand();
            case "list":
                return new ListCommand();
            case "save":
                return new SaveCommand();
            case "exit":
                return new ExitCommand();
            default:
                return new UnknownCommand(); // Obsługa nieznanych komend
        }
    }
}
