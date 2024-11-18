package org.example.lab.agh.command_package;

import org.example.lab.agh.model_package.Guest;
import org.example.lab.agh.model_package.Hotel;
import org.example.lab.agh.model_package.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveCommandTest {

    @Test
    public void testExecute() {
        // Tworzymy hotel z pokojami i zameldowanymi gośćmi
        Hotel hotel = new Hotel("Test Hotel", 1, 3);
        Room room101 = new Room(101, 200.0, 2);
        Room room102 = new Room(102, 250.0, 3);

        Guest guest1 = new Guest(123456789, "John", "Doe");
        Guest guest2 = new Guest(987654321, "Jane", "Doe");

        List<Guest> guestsRoom101 = new ArrayList<>();
        guestsRoom101.add(guest1);

        List<Guest> guestsRoom102 = new ArrayList<>();
        guestsRoom102.add(guest2);

        room101.setRoomRegisteredGuests(guestsRoom101);
        room102.setRoomRegisteredGuests(guestsRoom102);

        hotel.getRoomsMap().put(101, room101);
        hotel.getRoomsMap().put(102, room102);

        // Tworzymy obiekt SaveCommand i uruchamiamy metodę execute
        SaveCommand saveCommand = new SaveCommand(hotel);

        // Sprawdzamy, czy metoda execute() działa bez wyjątku
        assertDoesNotThrow(saveCommand::execute, "Saving guest state should not throw an exception");
    }
}