package org.example.lab.agh;

import org.example.lab.agh.command_package.*;
import org.example.lab.agh.model_package.Hotel;

public class CommandFactory {
    public Command getCommand(String userInput, Hotel hotel){
        switch(userInput) {
            case "prices":
                return new PricesCommand(hotel);
            case "view":
                return new ViewCommand(hotel);
            case "checkin":
                return new CheckinCommand(hotel);
            case "checkout":
                return new CheckoutCommand(hotel);
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
