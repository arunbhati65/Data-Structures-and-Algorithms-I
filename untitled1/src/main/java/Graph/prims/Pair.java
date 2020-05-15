package main.java.Graph.prims;

import java.util.Objects;

public class Pair implements Comparable {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        int key1 = key;
        int key2 = ((Pair)o).key;
        return key1-key2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
