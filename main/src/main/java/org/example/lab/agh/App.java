package org.example.lab.agh;

import org.example.lab.agh.command_package.Command;
import org.example.lab.agh.command_package.ExitCommand;
import org.example.lab.agh.command_package.PricesCommand;
import org.example.lab.agh.model_package.Hotel;

import java.util.Scanner;

public class App {
    private final Hotel ourHotel;
    private final MyMap<String, PricesCommand> commandsMap = new MyMap<>();

    public App(){
        this.ourHotel = new Hotel();
    }

    public void runApp(){
        System.out.println("====Welcome to Textual Hotel Manager!====");
        Scanner mainScanner = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();

        while(true){

            System.out.print("Choose the command {prices, view, exit}: ");
            String userChoice = mainScanner.nextLine().trim().toLowerCase();
            Command chosenCommand= commandFactory.getCommand(userChoice);
            chosenCommand.execute();
            if (chosenCommand instanceof ExitCommand) {break;}

        }


        mainScanner.close();
    }

    public static void main(String[] args) {
        new App().runApp();
    }
}