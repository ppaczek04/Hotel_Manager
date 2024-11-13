package org.example.lab.agh.command_package;

import org.example.lab.agh.Map;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

public class PricesCommand implements Command{
    private Hotel tempHotel;

    public PricesCommand(Hotel hotel){
        this.tempHotel = hotel;
    }

    public void execute(){
        Map<Integer, Room> tempMap = tempHotel.getRoomsMap();
        for(Integer key : tempMap.keys()){
            System.out.printf("Room %d: %.2f $ per night %n", key, tempMap.get(key).getPricePerNight());
        }
    }
}
