package org.example.lab.agh;

import java.util.List;

/**
 * The {@code Map} interface represents a mapping of keys to values.
 * It provides methods to add, remove, and retrieve key-value pairs.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface Map<K, V> {

    /**
     * Adds an element to the map under the specified key.
     * If the key already exists, the method should replace the value.
     *
     * @param key the key (not null)
     * @param value the value associated with the key (not null)
     * @return true if the element was successfully added, false otherwise
     */
    boolean put(K key, V value);

    /**
     * Removes the specified key and its associated value from the map.
     *
     * @param key the key to be removed
     * @return true if the key was successfully removed, false otherwise
     */
    boolean remove(K key);

    /**
     * Retrieves the value associated with the specified key, or null if the key does not exist.
     *
     * @param key the key (not null)
     * @return the value associated with the key, or null if the key does not exist
     */
    V get(K key);

    /**
     * Returns a list of all keys in the map.
     *
     * @return a {@code java.util.List} of keys
     */
    List<K> keys();

    /**
     * Checks if the specified key exists in the map.
     *
     * @param key the key to check for
     * @return true if the key exists, false otherwise
     */
    boolean contains(K key);
}