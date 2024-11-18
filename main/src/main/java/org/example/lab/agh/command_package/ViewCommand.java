package org.example.lab.agh.command_package;

import org.example.lab.agh.Map;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import java.util.Scanner;

/**
 * The {@code ViewCommand} class implements the {@code Command} interface
 * and allows the user to view detailed information about a specific hotel room.
 * <p>
 * This command prompts the user to select a room by its number and displays
 * information about the selected room if it exists.
 * </p>
 */
public class ViewCommand implements Command{

    /**
     * The hotel from which room information will be retrieved.
     */
    private Hotel tempHotel;

    /**
     * The scanner used to read user input for selecting a room.
     */
    private Scanner tempScanner;

    /**
     * Constructs a new {@code ViewCommand} with the specified hotel and scanner.
     *
     * @param hotel   the hotel containing the rooms
     * @param scanner the scanner used to gather user input
     */
    public ViewCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }

    /**
     * Executes the view command, prompting the user to choose a room and displaying
     * its information if it exists.
     * <p>
     * This method performs the following:
     * <ul>
     *     <li>Prompts the user to select a room by entering its number.</li>
     *     <li>Checks if the room exists in the hotel's map of rooms.</li>
     *     <li>If the room exists, its details are displayed.</li>
     *     <li>If the room does not exist, an appropriate message is shown.</li>
     * </ul>
     *
     */
    public void execute(){
        System.out.print("Choose the room that interests you: ");
        int userChoice = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()
        Map<Integer, Room> tempMap = tempHotel.getRoomsMap();

        if(!tempMap.contains(userChoice)){
            System.out.println("There is no such room.");
        }
        else{
            Room tempRoom = tempMap.get(userChoice);
            tempRoom.displayInfo();
        }
    }
}