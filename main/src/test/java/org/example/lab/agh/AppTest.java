package org.example.lab.agh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void twoPlusTwoIsFour_addition() {
        App app = new App();
        int result = app.addition(2,2);
        assertEquals(4, result);
    }
    @Test
    void twoPlusFourIsSix_addition() {
        App app = new App();
        assertEquals(6, app.addition(2,4));
    }
}