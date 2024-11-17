package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;


/**
 * The {@code ListCommand} class implements the {@code Command} interface
 * and provides functionality for listing all rooms and their availability.
 */
public class ListCommand implements Command{

    /**
     * Reference to the hotel containing the rooms to be listed.
     */
    private Hotel tempHotel;

    /**
     * Constructs a {@code ListCommand} object.
     *
     * @param hotel the {@code Hotel} object whose rooms will be listed
     */
    public ListCommand(Hotel hotel){
        this.tempHotel = hotel;
    }

    /**
     * Executes the command by displaying a list of all rooms and their availability.
     * <p>
     * This method retrieves the rooms from the hotel's room map and displays
     * information about each room.
     * </p>
     */
    public void execute(){
        System.out.println("List of all rooms and their availability:");
        MyMap<Integer, Room> roomsMap = tempHotel.getRoomsMap();
        for(Integer key : roomsMap.keys()){
            roomsMap.get(key).displayInfo();
        }
    }
}