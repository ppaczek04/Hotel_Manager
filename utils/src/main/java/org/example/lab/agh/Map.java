package org.example.lab.agh;


import java.util.List;

public interface Map<K, V> {
    /**
     * Dodanie elementu do mapy pod podanym kluczem.
     Jeśli podany klucz istnieje to metoda powinna podmienić wartość.
     * @param key klucz (nie null)
     * @param value wartość kryjącą się pod kluczem (nie null)
     * @return true jeśli się uda dodać element, false jeśli nie
     */
    boolean put(K key, V value);
    /**
     * Usunięcie podanego klucza oraz wartości, która jest przechowywana pod tym
     kluczem.
     * @param key klucz do usunięcia
     * @return true jeśli uda się usunać klucz, false w przeciwnym przypadku
     */
    boolean remove(K key);
    /**
     * Zwraca wartość pod podanym kluczem lub null jeśli nie ma podanego klucza.
     * @param key klucz (nie ull)
     * @return wartość pod kluczem lub null jeśli nie ma wartości dla podanego klucza
     */
    V get(K key);
    /**
     * Zwraca listę kluczy
     * @return java.util.List lista kluczy
     */
    List<K> keys();
    /**
     * Sprawdza czy podany klucz istnieje w mapie.
     * @param key wartość klucza do sprawdzenia.
     * @return true jeśli klucz istnieje.
     */
    boolean contains(K key);
}