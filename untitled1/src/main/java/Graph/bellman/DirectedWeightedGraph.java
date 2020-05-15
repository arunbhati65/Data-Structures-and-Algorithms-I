package main.java.Graph.bellman;

import java.util.ArrayList;

public class DirectedWeightedGraph {
    ArrayList<ArrayList<Node>> adjacencyList;
    int v;

    public DirectedWeightedGraph(int v) {
        this.v = v;
        this.adjacencyList = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int vertex1, int vertex2, int weight) {
        this.adjacencyList.get(vertex1).add(new Node(vertex2, weight));
    }

    public void bellmanFord(int start, int finish) {
        Integer[] distances = new Integer[v];
        for (int vertex = 0; vertex < v; ++vertex) {
            if (vertex == start) {
                distances[vertex] = 0;
            } else {
                distances[vertex] = Integer.MAX_VALUE;
            }
        }

        for (int V = 1; V < v; ++V) {
            for (Node vertexU : this.adjacencyList.get(V)) {
                int U = vertexU.vertex;
                int UVWeight = vertexU.weight;
                if (distances[U] != Integer.MAX_VALUE && (distances[U] + UVWeight) < distances[V]) {
                    distances[V] = distances[U] + UVWeight;
                }
            }
        }

        for (int V = 0; V < 4; ++V) {
            for (Node vertexU : this.adjacencyList.get(V)) {
                int U = vertexU.vertex;
                int UVWeight = vertexU.weight;
                if (distances[U] != Integer.MAX_VALUE && (distances[U] + UVWeight) < distances[V]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        System.out.println(distances);

    }
}