package org.example.lab.agh;

import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MyMapTest {

    @Test
    void testPutNewKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertTrue(map.put("A", 1));
        assertEquals(1, map.get("A"));
    }

    @Test
    void testPutExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertFalse(map.put("A", 2));
        assertEquals(2, map.get("A"));
    }

    @Test
    @Tag("Error_test")
    void testPutNullValueElement(){
        MyMap<String, Integer> map = new MyMap<>();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    map.put("A", null);
                });
    }

    @Test
    @Tag("Error_test")
    void testPutNullKeyElement(){
        MyMap<String, Integer> map = new MyMap<>();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    map.put(null, 1);
                });
    }

    @Test
    void testRemoveExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertTrue(map.remove("A"));
        assertNull(map.get("A"));
    }

    @Test
    void testRemoveNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertFalse(map.remove("A"));
    }

    @Test
    void testGetExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 1);
        assertEquals(1, map.get("A"));
    }

    @Test
    void testGetNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.get("A"));
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
        assertTrue(map.contains("A"));
    }

    @Test
    void testContainsNonExistingKey() {
        MyMap<String, Integer> map = new MyMap<>();
        assertFalse(map.contains("A"));
    }
}