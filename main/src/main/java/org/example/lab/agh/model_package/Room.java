package org.example.lab.agh.model_package;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a hotel room with attributes such as room number, price per night,
 * maximum guest capacity, and registered guests.
 */
public class Room {

    /**
     * The unique room number.
     */
    private final int roomNumber;

    /**
     * The price per night for the room.
     */
    private final double pricePerNight;

    /**
     * The maximum number of guests allowed in the room.
     */
    private final int maxGuestNumber;

    /**
     * A list of guests currently registered in the room.
     */
    private List<Guest> roomRegisteredGuests;

    /**
     * The check-in date for the room.
     */
    private LocalDate checkinDate;

    /**
     * The check-out date for the room.
     */
    private LocalDate checkoutDate;

    /**
     * Constructs a {@code Room} with specified attributes.
     *
     * @param roomNumber     the unique room number
     * @param price          the price per night for the room
     * @param maxGuestNumber the maximum number of guests allowed in the room
     */
    public Room(int roomNumber, double price, int maxGuestNumber) {
        this.roomNumber = roomNumber;
        this.pricePerNight = price;
        this.maxGuestNumber = maxGuestNumber;
        this.roomRegisteredGuests = new ArrayList<>();
        this.checkinDate = null;
        this.checkoutDate = null;
    }

    /**
     * Registers a guest by reading their details from the provided {@link Scanner}.
     *
     * @param tempScanner the scanner used to read guest details
     */
    public void registerGuest(Scanner tempScanner){
        System.out.print("Name: ");
        String name = tempScanner.nextLine();
        System.out.print("Surname: ");
        String surname = tempScanner.nextLine();
        System.out.print("PESEL: ");
        int PESEL = tempScanner.nextInt();
        tempScanner.nextLine();  // Czyści znak nowej linii Enter po nextInt()
        this.guestCheckin(new Guest(PESEL, name, surname));
    }

    /**
     * Signs out all guests and calculates the total cost of their stay.
     *
     * @return the total cost of the stay as a {@link BigDecimal}
     */
    public BigDecimal signOutGuests(){
        BigDecimal priceForNight = BigDecimal.valueOf(pricePerNight);
        long daysBetween = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
        BigDecimal numberOfDays = BigDecimal.valueOf(daysBetween);


        roomRegisteredGuests.clear();
        checkinDate = null;
        checkoutDate = null;

        return priceForNight.multiply(numberOfDays);
    }

    /**
     * Displays detailed information about the room, including occupancy status and guests.
     */
    public void displayInfo(){
        System.out.printf("** Room %d | %.2f $ per night | max Guests: %d ** ", roomNumber, pricePerNight, maxGuestNumber);
        if(roomRegisteredGuests.isEmpty()){
            System.out.println("Room AVAILABLE");
        }
        else{
            System.out.printf("Room is occupied since %s till %s by: %n", checkinDate.toString(), checkoutDate.toString());
            for(Guest guest : roomRegisteredGuests){
                System.out.println(guest.toString());
            }
        }
    }

    /**
     * Registers a guest by adding them to the room's guest list.
     *
     * @param guest the guest to register
     */
    public void guestCheckin(Guest guest){
        roomRegisteredGuests.add(guest);
    }

    /**
     * Returns the room number.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the price per night for the room.
     *
     * @return the price per night
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Returns the maximum number of guests allowed in the room.
     *
     * @return the maximum guest number
     */
    public int getMaxGuestNumber() {
        return maxGuestNumber;
    }

    /**
     * Returns the list of guests currently registered in the room.
     *
     * @return the list of registered guests
     */
    public List<Guest> getRoomRegisteredGuests() {
        return roomRegisteredGuests;
    }

    /**
     * Sets the list of registered guests in the room.
     *
     * @param roomRegisteredGuests the new list of registered guests
     */
    public void setRoomRegisteredGuests(List<Guest> roomRegisteredGuests) {
        this.roomRegisteredGuests = roomRegisteredGuests;
    }

    /**
     * Returns the check-in date for the room.
     *
     * @return the check-in date
     */
    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    /**
     * Sets the check-in date for the room.
     *
     * @param checkinDate the new check-in date
     */
    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    /**
     * Returns the check-out date for the room.
     *
     * @return the check-out date
     */
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * Sets the check-out date for the room.
     *
     * @param checkoutDate the new check-out date
     */
    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
