package org.example.lab.agh;

import org.example.lab.agh.command_package.*;
import org.example.lab.agh.model_package.Hotel;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CommandFactoryTest {
    private Hotel mockHotel;
    private CommandFactory commandFactory;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockHotel = mock(Hotel.class);
        mockScanner = mock(Scanner.class);
        commandFactory = new CommandFactory();
    }

    @Test
    void shouldReturnPricesCommandForPricesInput() {
        Command command = commandFactory.getCommand("prices", mockHotel, mockScanner);
        assertTrue(command instanceof PricesCommand, "Command should be an instance of PricesCommand");

    }

    @Test
    void shouldReturnViewCommandForViewInput() {
        Command command = commandFactory.getCommand("view", mockHotel, mockScanner);
        assertTrue(command instanceof ViewCommand, "Command should be an instance of ViewCommand");
    }

    @Test
    void shouldReturnCheckinCommandForCheckinInput() {
        Command command = commandFactory.getCommand("checkin", mockHotel, mockScanner);
        assertTrue(command instanceof CheckinCommand, "Command should be an instance of CheckinCommand");
    }

    @Test
    void shouldReturnCheckoutCommandForCheckoutInput() {
        Command command = commandFactory.getCommand("checkout", mockHotel, mockScanner);
        assertTrue(command instanceof CheckoutCommand, "Command should be an instance of CheckoutCommand");
    }

    @Test
    void shouldReturnListCommandForListInput() {
        Command command = commandFactory.getCommand("list", mockHotel, mockScanner);
        assertTrue(command instanceof ListCommand, "Command should be an instance of ListCommand");
    }

    @Test
    void shouldReturnSaveCommandForSaveInput() {
        Command command = commandFactory.getCommand("save", mockHotel, mockScanner);
        assertTrue(command instanceof SaveCommand, "Command should be an instance of SaveCommand");
    }

    @Test
    void shouldReturnExitCommandForExitInput() {
        Command command = commandFactory.getCommand("exit", mockHotel, mockScanner);
        assertTrue(command instanceof ExitCommand, "Command should be an instance of ExitCommand");
    }

    @Test
    void shouldReturnUnknownCommandForInvalidInput() {
        Command command = commandFactory.getCommand("invalid", mockHotel, mockScanner);
        assertTrue(command instanceof UnknownCommand, "Command should be an instance of UnknownCommand");
    }
}