package org.example.lab.agh.model_package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.lab.agh.MyMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private Hotel hotel;
    private MyMap<Integer, Room> mockRoomsMap;

    @BeforeEach
    void setUp() {
        mockRoomsMap = new MyMap<>();
        hotel = new Hotel("Test Hotel", 5, 10, mockRoomsMap);
    }

    @Test
    void testConstructorAndGetters() {

        // Act & Assert
        assertEquals("Test Hotel", hotel.getHotelName());
        assertEquals(5, hotel.getFloorNumber());
        assertEquals(10, hotel.getRoomsPerFloor());
        assertEquals(mockRoomsMap, hotel.getRoomsMap());
    }

    @Test
    void testSetHotelName() {
        // Act
        hotel.setHotelName("New Hotel Name");

        // Assert
        assertEquals("New Hotel Name", hotel.getHotelName());
    }

    @Test
    void testSetFloorNumber() {
        // Act
        hotel.setFloorNumber(7);

        // Assert
        assertEquals(7, hotel.getFloorNumber());
    }

    @Test
    void testSetRoomsPerFloor() {
        // Act
        hotel.setRoomsPerFloor(15);

        // Assert
        assertEquals(15, hotel.getRoomsPerFloor());
    }

    @Test
    void testSetRoomsMap() {
        // Arrange
        MyMap<Integer, Room> newRoomsMap = new MyMap<>();

        // Act
        hotel.setRoomsMap(newRoomsMap);

        // Assert
        assertEquals(newRoomsMap, hotel.getRoomsMap());
    }
}