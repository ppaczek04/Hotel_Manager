package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;

public class CheckinCommand implements Command{
    private Hotel tempHotel;

    public CheckinCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("Checkin command executed");
    }
}