package org.example.lab.agh.command_package;

public class UnknownCommand implements  Command{
    public void execute(){
        System.out.println("Unknown command, maybe typo??");
    }
}
