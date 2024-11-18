package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CheckinCommandTest {
    private Hotel mockHotel;
    private Scanner mockScanner;
    private CheckinCommand checkinCommand;
    private Room mockRoom;
    private MyMap<Integer, Room> mockRoomsMap;

    @BeforeEach
    void setUp() {
        mockHotel = mock(Hotel.class);
        mockScanner = mock(Scanner.class);
        mockRoom = mock(Room.class);

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

        checkinCommand = new CheckinCommand(mockHotel, mockScanner);

        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.contains(999)).thenReturn(false);
        
    }

    @Test
    void testRoomDoesNotExist() {
        when(mockScanner.nextInt()).thenReturn(999);
        when(mockScanner.nextLine()).thenReturn("");

        checkinCommand.execute();

        verify(mockHotel).getRoomsMap();
        verify(mockRoom, never()).getRoomRegisteredGuests();
    }

    @Test
    void testRoomIsOccupied() {
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class);
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(false);

        checkinCommand.execute();

        verify(mockHotel, times(2)).getRoomsMap();
        verify(mockRoom).getRoomRegisteredGuests();
    }

    @Test
    void testValidRoomBooking() {
        when(mockScanner.nextInt()).thenReturn(101, 2);
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class);
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(true);

        when(mockRoom.getMaxGuestNumber()).thenReturn(3);
        when(mockScanner.nextLine()).thenReturn("2024-11-20");

        checkinCommand.execute();

        verify(mockHotel, times(2)).getRoomsMap();
        verify(mockRoom).getRoomRegisteredGuests();
        verify(mockRoom, times(2)).registerGuest(mockScanner);
        verify(mockRoom).setCheckinDate(any(LocalDate.class));
        verify(mockRoom).setCheckoutDate(LocalDate.parse("2024-11-20"));
    }
}