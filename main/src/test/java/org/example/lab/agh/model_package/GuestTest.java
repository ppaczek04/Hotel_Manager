package org.example.lab.agh.model_package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        int expectedPESEL = 123456789;
        String expectedName = "Peter";
        String expectedSurname = "Donat";

        // Act
        Guest guest = new Guest(expectedPESEL, expectedName, expectedSurname);

        // Assert
        assertEquals(expectedPESEL, guest.getPesel());
        assertEquals(expectedName, guest.getName());
        assertEquals(expectedSurname, guest.getSurname());
    }

    @Test
    void testToString() {
        // Arrange
        String expectedName = "Gregory";
        String expectedSurname = "Donat";
        Guest guest = new Guest(987654321, expectedName, expectedSurname);

        // Act
        String result = guest.toString();

        // Assert
        assertEquals(expectedName + " " + expectedSurname, result);
    }
}