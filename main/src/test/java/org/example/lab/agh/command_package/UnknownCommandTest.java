package org.example.lab.agh.command_package;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnknownCommandTest {
    private UnknownCommand unknownCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut;


    @BeforeEach
    void setUp() {
        unknownCommand = new UnknownCommand();
        System.setOut(new PrintStream(outputStream)); // Przekierowanie System.out na strumień
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void execute_printsUnknownCommandMessage() {
        unknownCommand.execute();

        assertEquals("Unknown command, maybe typo??\n", outputStream.toString().replace("\r\n", "\n"));
    }
}