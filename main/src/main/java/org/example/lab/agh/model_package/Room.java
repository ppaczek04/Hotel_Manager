package org.example.lab.agh.model_package;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    private final int roomNumber;
    private final double pricePerNight;
    private final int maxGuestNumber;
    private List<Guest> roomRegisteredGuests;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    public Room(int roomNumber, double price, int maxGuestNumber) {
        this.roomNumber = roomNumber;
        this.pricePerNight = price;
        this.maxGuestNumber = maxGuestNumber;
        this.roomRegisteredGuests = new ArrayList<>();
        this.checkinDate = null;
        this.checkoutDate = null;
    }

    public Room(int roomNumber, double price, int maxGuestNumber, List<Guest> roomRegisteredGuests) {
        this.roomNumber = roomNumber;
        this.pricePerNight = price;
        this.maxGuestNumber = maxGuestNumber;
        this.roomRegisteredGuests = roomRegisteredGuests;
        this.checkinDate = null;
        this.checkoutDate = null;
    }

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

    public BigDecimal signOutGuests(){
        BigDecimal priceForNight = BigDecimal.valueOf(pricePerNight);
        long daysBetween = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
        BigDecimal numberOfDays = BigDecimal.valueOf(daysBetween);


        roomRegisteredGuests.clear();
        checkinDate = null;
        checkoutDate = null;

        return priceForNight.multiply(numberOfDays);
    }

    public void guestCheckin(Guest guest){
        roomRegisteredGuests.add(guest);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getMaxGuestNumber() {
        return maxGuestNumber;
    }

    public List<Guest> getRoomRegisteredGuests() {
        return roomRegisteredGuests;
    }

    public void setRoomRegisteredGuests(List<Guest> roomRegisteredGuests) {
        this.roomRegisteredGuests = roomRegisteredGuests;
    }

    public void displayInfo(){
        System.out.printf("** Room %d | %.2f $ per night | max Guests: %d ** ", roomNumber, pricePerNight, maxGuestNumber);
        if(roomRegisteredGuests.isEmpty()){
            System.out.println("Room AVAILABLE");
        }
        else{
            System.out.printf("Room is occupied  till %s by: %n", checkoutDate.toString());
            for(Guest guest : roomRegisteredGuests){
                System.out.println(guest.toString());
            }
        }
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
