package org.example.lab.agh;

import org.example.lab.agh.command_package.Command;
import org.example.lab.agh.command_package.ExitCommand;
import org.example.lab.agh.command_package.PricesCommand;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.util.Scanner;

public class App {
    private final Hotel ourHotel;
    private final MyMap<String, PricesCommand> commandsMap = new MyMap<>();

    public App(){
        this.ourHotel = new Hotel("Podcarpatia", 5, 8);
        ourHotel.getRoomsMap().put(101,  new Room(101, 20, 2));
        ourHotel.getRoomsMap().put(102,  new Room(102, 22, 3));
        ourHotel.getRoomsMap().put(103,  new Room(103, 24, 4));
        ourHotel.getRoomsMap().put(104,  new Room(104, 26, 5));
    }

    public void runApp(){
        System.out.println("===============Welcome to Textual Hotel Manager!===============");
        Scanner mainScanner = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();

        while(true){

            System.out.print("Choose the command {prices, view, checkin, checkout, list, save, exit}: ");
            String userChoice = mainScanner.nextLine().trim().toLowerCase();
            Command chosenCommand= commandFactory.getCommand(userChoice, ourHotel, mainScanner);
            chosenCommand.execute();
            if (chosenCommand instanceof ExitCommand) {break;}

        }
        mainScanner.close();
    }

    public static void main(String[] args) {
        new App().runApp();
    }
}