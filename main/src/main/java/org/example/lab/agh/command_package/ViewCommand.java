package org.example.lab.agh.command_package;

import org.example.lab.agh.Map;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.util.Scanner;

public class ViewCommand implements Command{
    private Hotel tempHotel;
    private Scanner tempScanner;

    public ViewCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }
    public void execute(){
        System.out.println("Podaj nr pokoju, ktory cie interesuje: ");
        int userChoice = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()
        Map<Integer, Room> tempMap = tempHotel.getRoomsMap();

        if(!tempMap.contains(userChoice)){
            System.out.println("Nie ma pokoju o takim numerze.");
        }
        else{
            Room tempRoom = tempMap.get(userChoice);
            tempRoom.displayInfo();
        }
    }
}