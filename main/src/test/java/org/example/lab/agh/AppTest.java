package org.example.lab.agh;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testRunAppExitCommand() {
        String simulatedInput = "exit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            app.runApp();
        } finally {
            System.setOut(originalOut);
            System.setIn(System.in);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("===============Welcome to Textual Hotel Manager!==============="));
    }

    @Test
    void testRunAppUnknownCommand() {
        String simulatedInput = "unknown\nexit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            app.runApp();
        } finally {
            System.setOut(originalOut);
            System.setIn(System.in);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Unknown command, maybe typo??"));
    }
}