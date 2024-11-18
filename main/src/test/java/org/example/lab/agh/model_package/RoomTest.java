package org.example.lab.agh.model_package;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class RoomTest {

    private Room room;
    private final int roomNumber = 101;
    private final double pricePerNight = 100.00;
    private final int maxGuestNumber = 2;

    @BeforeEach
    void setUp() {
        room = new Room(roomNumber, pricePerNight, maxGuestNumber);
    }

    @Test
    void testRegisterGuest() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Peter", "Donat");
        when(mockScanner.nextInt()).thenReturn(1234);

        room.registerGuest(mockScanner);

        assertEquals(1, room.getRoomRegisteredGuests().size());
        assertEquals("Peter Donat", room.getRoomRegisteredGuests().get(0).toString());
    }

    @Test
    void testSignOutGuests() {
        room.setCheckinDate(LocalDate.of(2023, 1, 1));
        room.setCheckoutDate(LocalDate.of(2023, 1, 3));

        BigDecimal expected = new BigDecimal("200.00"); // Upewnij się, że format jest zgodny
        assertEquals(0, expected.compareTo(room.signOutGuests()));
    }

    @Test
    void testDisplayInfoForEmptyRoom() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        room.displayInfo();

        String expectedOutput = String.format("** Room %d | %.2f $ per night | max Guests: %d ** Room AVAILABLE%n",
                roomNumber, pricePerNight, maxGuestNumber);
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testDisplayInfoForOccupiedRoom() {
        room.guestCheckin(new Guest(123456789, "Peter", "Donat"));
        room.setCheckinDate(LocalDate.of(2023, 11, 10));
        room.setCheckoutDate(LocalDate.of(2023, 11, 12));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        room.displayInfo();

        String expectedOutput = String.format("** Room %d | %.2f $ per night | max Guests: %d ** Room is occupied since 2023-11-10 till 2023-11-12 by: %nPeter Donat%n",
                roomNumber, pricePerNight, maxGuestNumber);
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testGettersAndSetters() {
        room.setCheckinDate(LocalDate.of(2023, 11, 10));
        room.setCheckoutDate(LocalDate.of(2023, 11, 12));
        room.setRoomRegisteredGuests(new ArrayList<>());

        assertEquals(LocalDate.of(2023, 11, 10), room.getCheckinDate());
        assertEquals(LocalDate.of(2023, 11, 12), room.getCheckoutDate());
        assertTrue(room.getRoomRegisteredGuests().isEmpty());

        assertEquals(101, room.getRoomNumber());
        assertEquals(100, room.getPricePerNight());
        assertEquals(2, room.getMaxGuestNumber());
    }
}