package org.example.lab.agh.model_package;

import org.example.lab.agh.MyMap;

/**
 * Represents a hotel with a specified name, number of floors,
 * and number of rooms per floor. Manages a collection of rooms.
 */
public class Hotel {

    /**
     * The name of the hotel.
     */
    private String hotelName;

    /**
     * The number of floors in the hotel.
     */
    private int floorNumber;

    /**
     * The number of rooms per floor in the hotel.
     */
    private int roomsPerFloor;

    /**
     * A map storing the rooms of the hotel, identified by their room numbers.
     */
    private MyMap<Integer, Room> roomsMap;

    /**
     * Constructs a {@code Hotel} instance with the specified name, number of floors,
     * and number of rooms per floor. Initializes an empty map of rooms.
     *
     * @param hotelName    the name of the hotel
     * @param floorNumber  the number of floors in the hotel
     * @param roomsPerFloor the number of rooms per floor in the hotel
     */
    public Hotel(String hotelName, int floorNumber, int roomsPerFloor) {
        this.hotelName = hotelName;
        this.floorNumber = floorNumber;
        this.roomsPerFloor = roomsPerFloor;
        this.roomsMap = new MyMap<>();
    }

    /**
     * Constructs a {@code Hotel} instance with the specified name, number of floors,
     * number of rooms per floor, and a predefined map of rooms.
     *
     * @param hotelName    the name of the hotel
     * @param floorNumber  the number of floors in the hotel
     * @param roomsPerFloor the number of rooms per floor in the hotel
     * @param roomsMap     a map containing the rooms of the hotel
     */
    public Hotel(String hotelName, int floorNumber, int roomsPerFloor, MyMap<Integer, Room> roomsMap) {
        this.hotelName = hotelName;
        this.floorNumber = floorNumber;
        this.roomsPerFloor = roomsPerFloor;
        this.roomsMap = roomsMap;
    }

    /**
     * Returns the name of the hotel.
     *
     * @return the name of the hotel
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the name of the hotel.
     *
     * @param hotelName the new name of the hotel
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Returns the number of floors in the hotel.
     *
     * @return the number of floors in the hotel
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Sets the number of floors in the hotel.
     *
     * @param floorNumber the new number of floors in the hotel
     */
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * Returns the number of rooms per floor in the hotel.
     *
     * @return the number of rooms per floor in the hotel
     */
    public int getRoomsPerFloor() {
        return roomsPerFloor;
    }

    /**
     * Sets the number of rooms per floor in the hotel.
     *
     * @param roomsPerFloor the new number of rooms per floor in the hotel
     */
    public void setRoomsPerFloor(int roomsPerFloor) {
        this.roomsPerFloor = roomsPerFloor;
    }

    /**
     * Returns the map containing the rooms of the hotel.
     *
     * @return the map of rooms
     */
    public MyMap<Integer, Room> getRoomsMap() {
        return roomsMap;
    }

    /**
     * Sets the map containing the rooms of the hotel.
     *
     * @param roomsMap the new map of rooms
     */
    public void setRoomsMap(MyMap<Integer, Room> roomsMap) {
        this.roomsMap = roomsMap;
    }
}
