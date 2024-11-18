package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void chosenRoomExists(){
        Room mockRoom = mock(Room.class);
        MyMap<Integer, Room> mockRoomsMap = mock(MyMap.class);
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);
        when(mockRoomsMap.contains(101)).thenReturn(true);
        when(mockRoomsMap.get(101)).thenReturn(mockRoom);
        viewCommand.execute();

        verify(mockRoom, times(1)).displayInfo();
    }

}