package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

public class ListCommand implements Command{
    private Hotel tempHotel;

    public ListCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("List of all rooms and their availability:");
        MyMap<Integer, Room> roomsMap = tempHotel.getRoomsMap();
        for(Integer key : roomsMap.keys()){
            roomsMap.get(key).displayInfo();
        }
    }
}