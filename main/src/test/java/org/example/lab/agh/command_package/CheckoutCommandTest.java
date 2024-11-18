package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CheckoutCommandTest {

    private Hotel mockHotel;
    private Scanner mockScanner;
    private CheckoutCommand checkoutCommand;
    private Room mockRoom;
    private MyMap<Integer, Room> mockRoomsMap;

    @BeforeEach
    void setUp() {
        mockHotel = mock(Hotel.class);
        mockScanner = mock(Scanner.class);
        mockRoom = mock(Room.class);

        checkoutCommand = new CheckoutCommand(mockHotel, mockScanner);

        Room room1 = mock(Room.class);
        when(room1.getPricePerNight()).thenReturn(100.00);

        Room room2 = mock(Room.class);
        when(room2.getPricePerNight()).thenReturn(150.00);

        mockRoomsMap = mock(MyMap.class);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(101);
        tempList.add(102);

        when(mockRoomsMap.keys()).thenReturn(tempList);
        when(mockRoomsMap.get(101)).thenReturn(room1);
        when(mockRoomsMap.get(102)).thenReturn(room2);
        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);

        checkoutCommand = new CheckoutCommand(mockHotel, mockScanner);
    }

    @Test
    void testRoomDoesNotExist() {
        when(mockScanner.nextInt()).thenReturn(999);
        when(mockHotel.getRoomsMap().contains(999)).thenReturn(false);

        checkoutCommand.execute();

        verify(mockHotel, times(2)).getRoomsMap();
        verify(mockRoom, never()).getRoomRegisteredGuests();
    }

    @Test
    void testRoomIsEmpty() {
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockHotel.getRoomsMap().contains(101)).thenReturn(true);
        when(mockHotel.getRoomsMap().get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class);
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(true);

        checkoutCommand.execute();

        verify(mockRoom).getRoomRegisteredGuests();
        verify(mockRoom, never()).signOutGuests();
    }

    @Test
    void testCheckoutValidRoom() {
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockHotel.getRoomsMap().contains(101)).thenReturn(true);
        when(mockHotel.getRoomsMap().get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class);
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(false);

        when(mockRoom.signOutGuests()).thenReturn(new BigDecimal("200.00"));

        checkoutCommand.execute();

        verify(mockRoom).getRoomRegisteredGuests();
        verify(mockRoom).signOutGuests();
    }

}