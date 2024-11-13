package org.example.lab.agh;

import org.example.lab.agh.command_package.Command;
import org.example.lab.agh.command_package.*;
import org.example.lab.agh.model_package.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandFactoryTest {
    private Hotel mockHotel;
    private CommandFactory commandFactory;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockHotel = mock(Hotel.class); // Mockowanie Hotel, aby nie zależeć od jego implementacji
        mockScanner = mock(Scanner.class);
        commandFactory = new CommandFactory();
    }

    @Test
    void shouldReturnPricesCommandForPricesInput() {
        Command command = commandFactory.getCommand("prices", mockHotel, mockScanner);
        assertInstanceOf(PricesCommand.class, command);
    }

    @Test
    void shouldReturnViewCommandForViewInput() {
        Command command = commandFactory.getCommand("view", mockHotel, mockScanner);
        assertInstanceOf(ViewCommand.class, command);
    }

    @Test
    void shouldReturnCheckinCommandForCheckinInput() {
        Command command = commandFactory.getCommand("checkin", mockHotel, mockScanner);
        assertInstanceOf(CheckinCommand.class, command);
    }

    @Test
    void shouldReturnCheckoutCommandForCheckoutInput() {
        Command command = commandFactory.getCommand("checkout", mockHotel, mockScanner);
        assertInstanceOf(CheckoutCommand.class, command);
    }

    @Test
    void shouldReturnListCommandForListInput() {
        Command command = commandFactory.getCommand("list", mockHotel, mockScanner);
        assertInstanceOf(ListCommand.class, command);
    }

    @Test
    void shouldReturnSaveCommandForSaveInput() {
        Command command = commandFactory.getCommand("save", mockHotel, mockScanner);
        assertInstanceOf(SaveCommand.class, command);
    }

    @Test
    void shouldReturnExitCommandForExitInput() {
        Command command = commandFactory.getCommand("exit", mockHotel, mockScanner);
        assertInstanceOf(ExitCommand.class, command);
    }

    @Test
    void shouldReturnUnknownCommandForInvalidInput() {
        Command command = commandFactory.getCommand("invalid", mockHotel, mockScanner);
        assertInstanceOf(UnknownCommand.class, command);
    }
}