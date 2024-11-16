package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.math.BigDecimal;
import java.util.Scanner;

public class CheckoutCommand implements Command{
    private Hotel tempHotel;
    private Scanner tempScanner;

    public CheckoutCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }
    public void execute(){
        System.out.printf("Select the room for checkout operation: ");
        while(true){
            int userChoice = tempScanner.nextInt();
            tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()

            if (!tempHotel.getRoomsMap().contains(userChoice)) {
                System.out.print("Chosen room doesnt exist, please choose different room: ");
                continue;
            }
            Room chosenRoom = tempHotel.getRoomsMap().get(userChoice);
            if (chosenRoom.getRoomRegisteredGuests().isEmpty()) {
                System.out.print("Chosen room is empty (not booker right now), please choose different one: ");
                continue;
            }
            System.out.println("-------------------------------------------------------------");
            System.out.println("Thank You for choosing our Hotel for your travel destination!");
            BigDecimal finalPrice = chosenRoom.signOutGuests();
            System.out.printf("The booking final price is : %s $ %n", finalPrice.toString());
            System.out.println("-------------------------------------------------------------");
            break;
        }
    }
}