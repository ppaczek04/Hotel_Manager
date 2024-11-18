package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PricesCommandTest {
    private Hotel mockHotel;
    private PricesCommand pricesCommand;

    @BeforeEach()
    void setUp(){
       mockHotel = mock(Hotel.class);
       pricesCommand = new PricesCommand(mockHotel);
    }
    @Test
    void shouldReturnProperInfo() {
        Room room1 = mock(Room.class);
        when(room1.getPricePerNight()).thenReturn(100.00);

        Room room2 = mock(Room.class);
        when(room2.getPricePerNight()).thenReturn(150.00);

        MyMap<Integer, Room> mockRoomsMap = mock(MyMap.class);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(101);
        tempList.add(102);

        when(mockRoomsMap.keys()).thenReturn(tempList);
        when(mockRoomsMap.get(101)).thenReturn(room1);
        when(mockRoomsMap.get(102)).thenReturn(room2);

        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        pricesCommand.execute();

        String expectedOutput =
                "Room 101: 100,00 $ per night" + System.lineSeparator() +
                "Room 102: 150,00 $ per night" + System.lineSeparator();

        assertEquals(expectedOutput.trim(), outputStream.toString().trim());

        System.setOut(System.out);
    }
}