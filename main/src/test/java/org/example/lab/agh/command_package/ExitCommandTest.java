package org.example.lab.agh.command_package;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExitCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ExitCommand exitCommand;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        exitCommand = new ExitCommand();
    }

    @Test
    void testExecute() {
        exitCommand.execute();

        String expectedOutput = "************************************************" + System.lineSeparator()
                + "******** Thank you for using our App !! ********" + System.lineSeparator()
                + "************************************************" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(originalOut);
    }
}