package org.example.lab.agh.model_package;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GuestTest {

    @Test
    void testConstructorAndGetters() {
        int expectedPESEL = 123456789;
        String expectedName = "Peter";
        String expectedSurname = "Donat";
        Guest guest = new Guest(expectedPESEL, expectedName, expectedSurname);

        assertEquals(expectedPESEL, guest.getPesel());
        assertEquals(expectedName, guest.getName());
        assertEquals(expectedSurname, guest.getSurname());
    }

    @Test
    void testToString() {
        String expectedName = "Gregory";
        String expectedSurname = "Donat";
        Guest guest = new Guest(987654321, expectedName, expectedSurname);
        String result = guest.toString();

        assertEquals(expectedName + " " + expectedSurname, result);
    }
}