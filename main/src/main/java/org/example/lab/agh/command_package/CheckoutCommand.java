package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The {@code CheckoutCommand} class implements the {@code Command} interface
 * and handles the checkout process for a hotel room.
 * <p>
 * This class allows the user to select a room for checkout, validates the
 * room's status, and calculates the final price based on the stay duration.
 * </p>
 */
public class CheckoutCommand implements Command{

    /**
     * The hotel in which the checkout operation is performed.
     */
    private Hotel tempHotel;

    /**
     * The scanner used to read user input during the checkout process.
     */
    private Scanner tempScanner;

    /**
     * Constructs a new {@code CheckoutCommand} with the specified hotel and scanner.
     *
     * @param hotel   the hotel where the checkout process is executed
     * @param scanner the scanner used to gather user input
     */
    public CheckoutCommand(Hotel hotel, Scanner scanner){
        this.tempHotel = hotel;
        this.tempScanner = scanner;
    }

    /**
     * Executes the checkout command, guiding the user through the process of selecting
     * a room and calculating the final price for the stay.
     * <p>
     * This method performs the following:
     * <ul>
     *     <li>Prompts the user to select a room by entering its number.</li>
     *     <li>Validates if the selected room exists and is occupied.</li>
     *     <li>Calculates the final price based on the stay duration.</li>
     *     <li>Displays the final price and clears the room's registered guests.</li>
     * </ul>
     * If the room does not exist or is empty, appropriate messages are displayed, and
     * the checkout process is aborted.
     * </p>
     */
    public void execute(){
        System.out.printf("Select the room for checkout operation: ");

        int userChoice = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()

        if (!tempHotel.getRoomsMap().contains(userChoice)) {
            System.out.print("Chosen room doesnt exist, please choose different room.");
            return;
        }
        Room chosenRoom = tempHotel.getRoomsMap().get(userChoice);
        if (chosenRoom.getRoomRegisteredGuests().isEmpty()) {
            System.out.print("Chosen room is empty (not booker right now), please choose different one.");
            return;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Thank You for choosing our Hotel for your travel destination!");
        BigDecimal finalPrice = chosenRoom.signOutGuests();
        System.out.printf("The booking final price is : %s $ %n", finalPrice.toString());
        System.out.println("-------------------------------------------------------------");
    }
}