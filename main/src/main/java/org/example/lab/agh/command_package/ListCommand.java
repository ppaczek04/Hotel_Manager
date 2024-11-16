package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;

public class ListCommand implements Command{
    private Hotel tempHotel;

    public ListCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("List of all rooms and their availability:");
        for(Integer key : tempHotel.getRoomsMap().keys()){
            tempHotel.getRoomsMap().get(key).displayInfo();
        }
    }
}