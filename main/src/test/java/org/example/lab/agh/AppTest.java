package org.example.lab.agh;

import org.example.lab.agh.command_package.Command;
import org.example.lab.agh.command_package.ExitCommand;
import org.example.lab.agh.command_package.UnknownCommand;
import org.example.lab.agh.model_package.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testRunAppExitCommand() {
        // Symulowane wejście użytkownika: użytkownik wprowadza komendę "exit"
        String simulatedInput = "exit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Przechwytywanie wyjścia konsoli
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            app.runApp();
        } finally {
            // Przywracanie oryginalnego wyjścia
            System.setOut(originalOut);
            System.setIn(System.in);
        }

        // Sprawdzenie, czy w wyjściu znajduje się wiadomość powitalna
        String output = outputStream.toString();
        assertTrue(output.contains("===============Welcome to Textual Hotel Manager!==============="));
    }

    @Test
    void testRunAppUnknownCommand() {
        // Symulowane wejście: użytkownik podaje nieznaną komendę, a potem "exit"
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

        // Sprawdzenie, czy została wypisana wiadomość o nieznanej komendzie
        String output = outputStream.toString();
        assertTrue(output.contains("Unknown command, maybe typo??"));
    }
}