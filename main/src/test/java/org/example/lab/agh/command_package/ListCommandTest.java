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

        // Mockowanie pokoi
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);

        // Mockowanie mapy pokoi
        MyMap<Integer, Room> mockRoomsMap = mock(MyMap.class);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(101);
        tempList.add(102);

        // Podłączanie mapy do mockHotel
        when(mockHotel.getRoomsMap()).thenReturn(mockRoomsMap);

        when(mockRoomsMap.keys()).thenReturn(tempList);
        when(mockRoomsMap.get(101)).thenReturn(room1);
        when(mockRoomsMap.get(102)).thenReturn(room2);

        listCommand.execute();

        verify(mockHotel).getRoomsMap(); // Upewniamy się, że metoda getRoomsMap() została wywołana
        verify(mockRoomsMap).keys(); // Upewniamy się, że klucze zostały pobrane
        verify(mockRoomsMap).get(101); // Pobranie pierwszego pokoju
        verify(mockRoomsMap).get(102); // Pobranie drugiego pokoju
        verify(room1).displayInfo(); // Wyświetlenie informacji dla pierwszego pokoju
        verify(room2).displayInfo(); // Wyświetlenie informacji dla drugiego pokoju



    }
}