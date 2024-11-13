package org.example.lab.agh;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> implements Map<K, V> {

    private final ArrayList<K> keys = new ArrayList<>();
    private final ArrayList<V> values = new ArrayList<>();

    // nasza mapa składa sie z dwóch list, i jeśli klucz jest 3 elementem listy key,
    // to przypisana do niego wartość  jest 3 elementem listy values

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
            return false; // klucz juz jest w mapie, wiec podmieniono tylko przechowywana pod nim wartosc;
        }
    }

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

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);

        if (index == -1) { //jesli nie ma szukanego klucza w liscie zwracana jestw wartosc -1
            return null; // nie bylo takiego klucza w mapie, wiec nie ma pod nim zadnej wartosci, wiec zwracamy null
        } else {
            return values.get(index);
        }
    }

    @Override
    public List<K> keys() {

        return new ArrayList<>(keys); // zwraca kopie aby zapobiec zewnetrznym modyfikacjom
    }

    @Override
    public boolean contains(K key) {
        return keys.contains(key);
        //jesli nie ma szukanego klucza w liscie zwracana jestw wartosc false
        //jest taki klucz w mapie jwst to zwracane jest true
    }
}
