package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;

public class ListCommand implements Command{
    private Hotel tempHotel;

    public ListCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("List command executed");
    }
}