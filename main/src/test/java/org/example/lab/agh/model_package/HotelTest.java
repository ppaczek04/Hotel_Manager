package org.example.lab.agh.model_package;

import org.example.lab.agh.MyMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
        assertEquals("Test Hotel", hotel.getHotelName());
        assertEquals(5, hotel.getFloorNumber());
        assertEquals(10, hotel.getRoomsPerFloor());
        assertEquals(mockRoomsMap, hotel.getRoomsMap());
    }

    @Test
    void testSetHotelName() {
        hotel.setHotelName("New Hotel Name");

        assertEquals("New Hotel Name", hotel.getHotelName());
    }

    @Test
    void testSetFloorNumber() {
        hotel.setFloorNumber(7);

        assertEquals(7, hotel.getFloorNumber());
    }

    @Test
    void testSetRoomsPerFloor() {
        hotel.setRoomsPerFloor(15);

        assertEquals(15, hotel.getRoomsPerFloor());
    }

    @Test
    void testSetRoomsMap() {
        MyMap<Integer, Room> newRoomsMap = new MyMap<>();
        hotel.setRoomsMap(newRoomsMap);

        assertEquals(newRoomsMap, hotel.getRoomsMap());
    }
}