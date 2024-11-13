package org.example.lab.agh.model_package;

import org.example.lab.agh.MyMap;

public class Hotel {
    private String hotelName;
    private int floorNumber;
    private int roomsPerFloor;
    private MyMap<Integer, Room> roomsMap;

    public Hotel(String hotelName, int floorNumber, int roomsPerFloor) {
        this.hotelName = hotelName;
        this.floorNumber = floorNumber;
        this.roomsPerFloor = roomsPerFloor;
        this.roomsMap = new MyMap<>();
    }

    public Hotel(String hotelName, int floorNumber, int roomsPerFloor, MyMap<Integer, Room> roomsMap) {
        this.hotelName = hotelName;
        this.floorNumber = floorNumber;
        this.roomsPerFloor = roomsPerFloor;
        this.roomsMap = roomsMap;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomsPerFloor() {
        return roomsPerFloor;
    }

    public void setRoomsPerFloor(int roomsPerFloor) {
        this.roomsPerFloor = roomsPerFloor;
    }

    public MyMap<Integer, Room> getRoomsMap() {
        return roomsMap;
    }

    public void setRoomsMap(MyMap<Integer, Room> roomsMap) {
        this.roomsMap = roomsMap;
    }
}
