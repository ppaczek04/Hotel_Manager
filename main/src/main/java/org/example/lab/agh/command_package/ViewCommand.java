package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;

public class ViewCommand implements Command{
    private Hotel tempHotel;

    public ViewCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("View command executed");
    }
}