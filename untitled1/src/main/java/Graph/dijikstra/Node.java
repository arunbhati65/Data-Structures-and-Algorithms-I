package main.java.Graph.dijikstra;

import java.util.Objects;

public class Node implements Comparable {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return vertex == node.vertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }

    @Override
    public int compareTo(Object o) {
        return this.weight - ((Node) o).weight;
    }
}
