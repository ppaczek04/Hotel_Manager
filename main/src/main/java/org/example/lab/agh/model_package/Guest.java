package org.example.lab.agh.model_package;

public class Guest {
    private final int PESEL;
    private final String name;
    private final String surname;

    public Guest(int PESEL, String name, String surname) {
        this.PESEL = PESEL;
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }

    public int getPESEL() {
        return PESEL;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
