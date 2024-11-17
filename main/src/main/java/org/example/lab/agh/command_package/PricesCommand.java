package org.example.lab.agh.command_package;

import org.example.lab.agh.Map;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;

/**
 * The {@code PricesCommand} class represents a command that displays the prices
 * of all rooms in a hotel.
 * <p>
 * This class is part of the Command design pattern. It fetches and displays
 * the price per night for each room in the hotel when executed.
 * </p>
 */
public class PricesCommand implements Command{

    /**
     * The hotel object containing the rooms whose prices are displayed.
     */
    private Hotel tempHotel;

    /**
     * Constructs a {@code PricesCommand} with the specified hotel.
     *
     * @param hotel the hotel whose room prices are to be displayed
     */
    public PricesCommand(Hotel hotel){
        this.tempHotel = hotel;
    }

    /**
     * Executes the command to display the prices of all rooms in the hotel.
     * <p>
     * For each room in the hotel, this method retrieves and prints its room
     * number and price per night.
     * </p>
     */
    public void execute(){
        Map<Integer, Room> tempMap = tempHotel.getRoomsMap();
        for(Integer key : tempMap.keys()){
            System.out.printf("Room %d: %.2f $ per night%n", key, tempMap.get(key).getPricePerNight());
        }
    }
}
