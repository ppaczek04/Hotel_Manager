package org.example.lab.agh;

import org.example.lab.agh.command_package.*;
import org.example.lab.agh.model_package.Hotel;

import java.util.Scanner;

public class CommandFactory {
    public Command getCommand(String userInput, Hotel hotel, Scanner mainScanner){
        switch(userInput) {
            case "prices":
                return new PricesCommand(hotel);
            case "view":
                return new ViewCommand(hotel, mainScanner);
            case "checkin":
                return new CheckinCommand(hotel, mainScanner);
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
