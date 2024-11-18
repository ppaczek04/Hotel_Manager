package org.example.lab.agh.command_package;

import org.example.lab.agh.MyMap;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


class ListCommandTest {
    private Hotel mockHotel;
    private ListCommand listCommand;

    @BeforeEach
    void setUp(){
        mockHotel = mock(Hotel.class);
        listCommand =  new ListCommand(mockHotel);
    }
    @Test
    void execute() {
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);

        MyMap<Integer, Room> mockRoomsMap = mock(MyMap.class);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(101);
        tempList.add(102);

        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);

        when(mockRoomsMap.keys()).thenReturn(tempList);
        when(mockRoomsMap.get(101)).thenReturn(room1);
        when(mockRoomsMap.get(102)).thenReturn(room2);

        listCommand.execute();

        verify(mockHotel).getRoomsMap();
        verify(mockRoomsMap).keys();
        verify(mockRoomsMap).get(101);
        verify(mockRoomsMap).get(102);
        verify(room1).displayInfo();
        verify(room2).displayInfo();
    }
}