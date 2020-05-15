package main.java.Graph.dijikstra;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<ArrayList<Node>> adjacencyList;
    int v;

    public WeightedGraph(int v) {
        this.v = v;
        this.adjacencyList = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int vertex1, int vertex2, int weight) {
        this.adjacencyList.get(vertex1).add(new Node(vertex2, weight));
        this.adjacencyList.get(vertex2).add(new Node(vertex1, weight));
    }

    public void dijkstra(int start, int finish) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Integer[] distances = new Integer[v];
        Integer[] parent = new Integer[v];
        String path = "";
        Integer smallestVertex;
        for (int vertex = 0; vertex < v; ++vertex) {
            if (vertex == start) {
                distances[vertex] = 0;
                priorityQueue.offer(new Node(vertex, 0));
            } else {
                distances[vertex] = Integer.MAX_VALUE;
                priorityQueue.offer(new Node(vertex, Integer.MAX_VALUE));
            }
            parent[vertex] = null;
        }

        while (!priorityQueue.isEmpty()) {
            smallestVertex = priorityQueue.poll().vertex;
            if (smallestVertex == finish) {
                while (parent[smallestVertex] != null) {
                    path = path + "-" + smallestVertex;
                    smallestVertex = parent[smallestVertex];
                }
                break;
            } else if (distances[smallestVertex] != Integer.MAX_VALUE) {
                for (Node adjacentVertex : this.adjacencyList.get(smallestVertex)) {
                    int weightToCompare = distances[smallestVertex] + adjacentVertex.weight;
                    if (weightToCompare < distances[adjacentVertex.vertex]) {
                        distances[adjacentVertex.vertex] = weightToCompare;
                        parent[adjacentVertex.vertex] = smallestVertex;
                        priorityQueue.offer(new Node(adjacentVertex.vertex, weightToCompare));
                    }
                }
            }
        }
        System.out.println(path.concat("-0"));
    }
}