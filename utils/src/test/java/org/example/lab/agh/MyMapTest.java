package org.example.lab.agh;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    @Test
    void testPutNewKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertTrue(map.put("A", 1)); // Nowy klucz, powinno zwrócić true
        assertEquals(1, map.get("A"));
    }

    @Test
    void testPutExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertFalse(map.put("A", 2)); // Klucz istnieje, powinno zwrócić false
        assertEquals(2, map.get("A")); // Wartość powinna zostać zaktualizowana do 2
    }

    @Test
    @Tag("Error_test")
    void testPutNullValueElement(){
        MyMap<String, Integer> map = new MyMap<>();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    map.put("A", null); //wartosc to null, powoduje error
                });
    }

    @Test
    @Tag("Error_test")
    void testPutNullKeyElement(){
        MyMap<String, Integer> map = new MyMap<>();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    map.put(null, 1); //klucz to null, powoduje error
                });
    }

    @Test
    void testRemoveExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertTrue(map.remove("A")); // Klucz istnieje, więc usunięcie powinno zwrócić true
        assertNull(map.get("A")); // Po usunięciu, wartość powinna być null
    }

    @Test
    void testRemoveNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertFalse(map.remove("A")); // Klucz nie istnieje, więc usunięcie powinno zwrócić false
    }

    @Test
    void testGetExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertEquals(1, map.get("A")); // Pobranie wartości dla istniejącego klucza
    }

    @Test
    void testGetNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.get("A")); // Pobranie wartości dla nieistniejącego klucza powinno zwrócić null
    }

    @Test
    void testKeys() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        map.put("B", 2);
        List<String> keys = map.keys();
        assertTrue(keys.contains("A"));
        assertTrue(keys.contains("B"));
        assertEquals(2, keys.size());
    }

    @Test
    void testContainsExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertTrue(map.contains("A")); // Klucz istnieje, więc powinno zwrócić true
    }

    @Test
    void testContainsNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertFalse(map.contains("A")); // Klucz nie istnieje, więc powinno zwrócić false
    }
}