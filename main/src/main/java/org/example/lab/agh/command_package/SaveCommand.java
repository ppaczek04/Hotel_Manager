package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;


/**
 *
 */
public class SaveCommand implements Command{
    private Hotel tempHotel;

    /**
     * @param hotel gygug
     */
    public SaveCommand(Hotel hotel){
        this.tempHotel = hotel;
    }

    /**
     *
     */
    public void execute(){
        System.out.println("Save command executed");
    }
}