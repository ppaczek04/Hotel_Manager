package org.example.lab.agh.command_package;


import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.lab.agh.model_package.Room;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;


class ViewCommandTest {

    private Hotel mockHotel;
    private ViewCommand viewCommand;
    private Scanner mockScanner;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp(){
        mockHotel = mock(Hotel.class);
        mockScanner = mock(Scanner.class);
        viewCommand = new ViewCommand(mockHotel, mockScanner);

        // Przechwytywanie wyjścia do konsoli
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void chosenRoomExists(){

        // Mockowanie pokoju i mapy
        Room mockRoom = mock(Room.class);
        MyMap<Integer, Room> mockRoomsMap = mock(MyMap.class);

        when(mockScanner.nextInt()).thenReturn(101); // Użytkownik wybiera pokój 101
        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap); // Zwracamy zamockowaną mapę
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);

        // Wykonanie metody
        viewCommand.execute();

        // Sprawdzenie, czy wywołano displayInfo na mockRoom
        verify(mockRoom, times(1)).displayInfo();
    }

}