package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Hotel;

public class CheckoutCommand implements Command{
    private Hotel tempHotel;

    public CheckoutCommand(Hotel hotel){
        this.tempHotel = hotel;
    }
    public void execute(){
        System.out.println("Checkout command executed");
    }
}