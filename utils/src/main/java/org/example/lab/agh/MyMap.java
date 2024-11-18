package org.example.lab.agh;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MyMap} class provides a simple implementation of the {@link Map} interface
 * using two {@link ArrayList}s to store keys and their corresponding values.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MyMap<K, V> implements Map<K, V> {

    /**
     * List of keys maintained by the map.
     */
    private final ArrayList<K> keys = new ArrayList<>();

    /**
     * List of values corresponding to the keys.
     */
    private final ArrayList<V> values = new ArrayList<>();

    /**
     * Adds a key-value pair to the map. If the key already exists, its value is updated.
     *
     * @param key   the key to add (not null)
     * @param value the value to associate with the key (not null)
     * @return {@code true} if the key-value pair was added successfully,
     *         {@code false} if the key already existed and its value was updated
     * @throws IllegalArgumentException if the key or value is {@code null}
     */
    @Override
    public boolean put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and/or value cannot be null");
        }

        int index = keys.indexOf(key);
        if (index == -1) { // klucza jeszcze nie ma w liście, wiec dodajemy key do keys, i value do values
            keys.add(key);
            values.add(value);
            return true;
        } else {
            values.set(index, value);
            return false;
        }
    }

    /**
     * Removes the key-value pair associated with the given key.
     *
     * @param key the key to remove
     * @return {@code true} if the key was removed successfully,
     *         mo{@code false} if the key did not exist in the map
     */
    @Override
    public boolean remove(K key) {
        int index = keys.indexOf(key);

        if (index == -1) { //jesli nie ma szukanego klucza w liscie zwracana jestw wartosc -1
            return false; // nie bylo takiego klucza w mapie
        } else {
            keys.remove(index);
            values.remove(index);
            return true;
        }
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key to look up
     * @return the value associated with the key, or {@code null} if the key does not exist
     */
    @Override
    public V get(K key) {
        int index = keys.indexOf(key);

        if (index == -1) { //jesli nie ma szukanego klucza w liscie zwracana jestw wartosc -1
            return null; // nie bylo takiego klucza w mapie, wiec nie ma pod nim zadnej wartosci, wiec zwracamy null
        } else {
            return values.get(index);
        }
    }

    /**
     * Returns a list of all keys in the map.
     *
     * @return a copy of the list of keys to prevent external modification
     */
    @Override
    public List<K> keys() {

        return new ArrayList<>(keys); // zwraca kopie aby zapobiec zewnetrznym modyfikacjom
    }

    /**
     * Checks if the map contains the specified key.
     *
     * @param key the key to check for
     * @return {@code true} if the key exists, {@code false} otherwise
     */
    @Override
    public boolean contains(K key) {
        return keys.contains(key);
        //jesli nie ma szukanego klucza w liscie zwracana jestw wartosc false
        //jest taki klucz w mapie jwst to zwracane jest true
    }
}
