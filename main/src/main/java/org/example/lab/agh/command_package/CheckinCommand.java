package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class CheckinCommand implements Command{
    private Hotel tempHotel;
    private Scanner tempScanner;

    public CheckinCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }

    public void execute(){
        System.out.print("Choose the room you want to book:");
        while(true){
            int userChoice = tempScanner.nextInt();
            tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()

            if(!tempHotel.getRoomsMap().contains(userChoice)){
                System.out.print("Chosen room doesnt exist, please choose different room: ");
                continue;
            }
            Room chosenRoom = tempHotel.getRoomsMap().get(userChoice);
            if(!chosenRoom.getRoomRegisteredGuests().isEmpty()){
                System.out.print("Chosen room is currently occupied, please choose different one: ");
                continue;
            }
            System.out.printf("How many guests? {%d} : ",chosenRoom.getMaxGuestNumber());
            int howManyGuests = tempScanner.nextInt();
            tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()
            if(howManyGuests > chosenRoom.getMaxGuestNumber()){
                System.out.print("Sorry, this room is not big enough for that many people, please choose different one: ");
                continue;
            }
            for(int i = 1; i <= howManyGuests; i++){
                System.out.printf("Please register %d. guest >> %n", i);
                chosenRoom.registerGuest(tempScanner);
            }
            System.out.printf("Checkin date is set to %s %n", LocalDate.now());
            chosenRoom.setCheckinDate(LocalDate.now());
            System.out.print("Please set te checkout date (YYYY-MM-DD): ");
            String checkoutDateString = tempScanner.nextLine().trim();
            LocalDate checkoutDate = LocalDate.parse(checkoutDateString);
            chosenRoom.setCheckoutDate(checkoutDate);
            break;
        }
    }
}