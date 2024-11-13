package org.example.lab.agh.model_package;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private double pricePerNight;
    private int maxGuestNumber;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxGuestNumber() {
        return maxGuestNumber;
    }

    public void setMaxGuestNumber(int maxGuestNumber) {
        this.maxGuestNumber = maxGuestNumber;
    }

    public List<Guest> getRoomRegisteredGuests() {
        return roomRegisteredGuests;
    }

    public void setRoomRegisteredGuests(List<Guest> roomRegisteredGuests) {
        this.roomRegisteredGuests = roomRegisteredGuests;
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
