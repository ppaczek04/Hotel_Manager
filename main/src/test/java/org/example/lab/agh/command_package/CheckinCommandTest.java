package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Guest;
import org.junit.jupiter.api.Test;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import org.junit.jupiter.api.BeforeEach;


import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckinCommandTest {
    private Hotel mockHotel;
    private Scanner mockScanner;
    private CheckinCommand checkinCommand;
    private Room mockRoom;
    private MyMap<Integer, Room> mockRoomsMap; // Zadeklarowane jako pole klasy

    @BeforeEach
    void setUp() {
        mockHotel = mock(Hotel.class);
        mockScanner = mock(Scanner.class);

        mockRoom = mock(Room.class);

        // Mockowanie pokoi
        Room room1 = mock(Room.class);
        when(room1.getPricePerNight()).thenReturn(100.00);

        Room room2 = mock(Room.class);
        when(room2.getPricePerNight()).thenReturn(150.00);

        // Mockowanie mapy pokoi

        mockRoomsMap = mock(MyMap.class);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(101);
        tempList.add(102);

        when(mockRoomsMap.keys()).thenReturn(tempList);
        when(mockRoomsMap.get(101)).thenReturn(room1);
        when(mockRoomsMap.get(102)).thenReturn(room2);

        // Poprawne przypisanie mocka mapy do hotelu
        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);

        checkinCommand = new CheckinCommand(mockHotel, mockScanner);

        // Mockowanie zachowań mapy
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.contains(999)).thenReturn(false);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);
    }

    @Test
    void testRoomDoesNotExist() {
        when(mockScanner.nextInt()).thenReturn(999); // Podaj nieistniejący pokój
        when(mockScanner.nextLine()).thenReturn(""); // Czyść wiersz

        checkinCommand.execute();

        verify(mockHotel).getRoomsMap();
        verify(mockRoom, never()).getRoomRegisteredGuests();
    }

    @Test
    void testRoomIsOccupied() {
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class); // Mockowana lista gości
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(false); // Stubowanie isEmpty() dla tej listy

        checkinCommand.execute();

        verify(mockHotel, times(2)).getRoomsMap();
        verify(mockRoom).getRoomRegisteredGuests();
    }

    @Test
    void testValidRoomBooking() {
        // Symulowanie wejścia użytkownika
        when(mockScanner.nextInt()).thenReturn(101, 2); // Wybór pokoju 101 i liczba gości 2
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);

        List<Guest> mockGuestList = mock(List.class); // Mockowana lista gości
        when(mockRoom.getRoomRegisteredGuests()).thenReturn(mockGuestList);
        when(mockGuestList.isEmpty()).thenReturn(true); // Pokój jest pusty

        when(mockRoom.getMaxGuestNumber()).thenReturn(3); // Maksymalnie 3 osoby w pokoju
        when(mockScanner.nextLine()).thenReturn("2024-11-20"); // Data wyjazdu

        // Uruchomienie metody
        checkinCommand.execute();

        // Weryfikacja poprawnego przepływu
        verify(mockHotel, times(2)).getRoomsMap();
        verify(mockRoom).getRoomRegisteredGuests();
        verify(mockRoom, times(2)).registerGuest(mockScanner); // Rejestracja 2 gości
        verify(mockRoom).setCheckinDate(any(LocalDate.class));
        verify(mockRoom).setCheckoutDate(LocalDate.parse("2024-11-20"));
    }
}