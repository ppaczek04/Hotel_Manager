package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * The {@code CheckinCommand} class implements the {@code Command} interface
 * and handles the check-in process for a hotel room.
 * <p>
 * This class allows the user to select a room, specify the number of guests,
 * and input check-in and check-out dates.
 * </p>
 */
public class CheckinCommand implements Command{

    /**
     * The hotel in which the check-in operation is performed.
     */
    private Hotel tempHotel;

    /**
     * The scanner used to read user input during the check-in process.
     */
    private Scanner tempScanner;

    /**
     * Constructs a new {@code CheckinCommand} with the specified hotel and scanner.
     *
     * @param hotel   the hotel where the check-in process is executed
     * @param scanner the scanner used to gather user input
     */
    public CheckinCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }

    /**
     * Executes the check-in command, guiding the user through the room selection
     * and guest registration process.
     * <p>
     * This method performs the following:
     * <ul>
     *     <li>Prompts the user to select a room by entering its number.</li>
     *     <li>Validates if the selected room exists and is not occupied.</li>
     *     <li>Asks for the number of guests and registers each guest.</li>
     *     <li>Requests check-in and check-out dates from the user.</li>
     * </ul>
     * Appropriate messages are displayed if invalid inputs are provided, and the
     * check-in is finalized by setting the room's occupancy details.
     *
     */
    public void execute(){
        System.out.print("Choose the room you want to book: ");

        int userChoice = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()

        if (!tempHotel.getRoomsMap().contains(userChoice)) {
            System.out.println("Chosen room doesnt exist, please choose different room.");
            return;
        }
        Room chosenRoom = tempHotel.getRoomsMap().get(userChoice);
        if (!chosenRoom.getRoomRegisteredGuests().isEmpty()) {
            System.out.println("Chosen room is currently occupied, please choose different one.");
            return;
        }
        System.out.printf("How many guests? {%d} : ", chosenRoom.getMaxGuestNumber());
        int howManyGuests = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()
        if (howManyGuests > chosenRoom.getMaxGuestNumber()) {
            System.out.println("Sorry, this room is not big enough for that many people, please choose different one.");
            return;
        }
        System.out.printf("Please register Main guest >> %n");
        chosenRoom.registerGuest(tempScanner);
        for (int i = 2; i <= howManyGuests; i++) {
            System.out.printf("Please register %d. guest >> %n", i);
            chosenRoom.registerGuest(tempScanner);
        }
        System.out.print("provide check-in and check-out dates (format: YYYY-MM-DD YYYY-MM-DD) or only check-out date: ");
        String inputDates = tempScanner.nextLine().trim();
        String[] dates = inputDates.split("\\s+");
        if (dates.length == 2) {
            chosenRoom.setCheckinDate(LocalDate.parse(dates[0]));
            chosenRoom.setCheckoutDate(LocalDate.parse(dates[1]));
        } else {
            chosenRoom.setCheckinDate(LocalDate.now());
            chosenRoom.setCheckoutDate(LocalDate.parse(dates[0]));
        }
        System.out.printf("Check-in date set to: %s%n", chosenRoom.getCheckinDate());
        System.out.printf("Check-out date set to: %s%n", chosenRoom.getCheckoutDate());
    }
}