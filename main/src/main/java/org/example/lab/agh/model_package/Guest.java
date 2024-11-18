package org.example.lab.agh.model_package;

/**
 * Represents a guest with personal details including PESEL, name, and surname.
 * This class provides methods to access the guest's information.
 */
public class Guest {

    /**
     * The PESEL (Polish national identification number) of the guest.
     */
    private final int pesel;

    /**
     * The first name of the guest.
     */
    private final String name;

    /**
     * The surname (last name) of the guest.
     */
    private final String surname;

    /**
     * Constructs a new Guest instance with the provided PESEL, name, and surname.
     *
     * @param pesel    the PESEL of the guest
     * @param name     the first name of the guest
     * @param surname  the surname (last name) of the guest
     */

    public Guest(int pesel, String name, String surname) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Returns a string representation of the guest in the format "name surname".
     *
     * @return a string representation of the guest's name and surname
     */
    @Override
    public String toString() {
        return name + " " + surname;
    }

    /**
     * Returns the PESEL of the guest.
     *
     * @return the PESEL of the guest
     */
    public int getPesel() {
        return pesel;
    }

    /**
     * Returns the first name of the guest.
     *
     * @return the first name of the guest
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the surname (last name) of the guest.
     *
     * @return the surname of the guest
     */
    public String getSurname() {
        return surname;
    }
}
