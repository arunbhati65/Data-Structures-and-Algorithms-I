package main.java.Graph.prims;

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

    public void prims_mst() {
        boolean[] mst=new boolean[v];
        ResultSet[] resultSet=new ResultSet[v];
        int[] distance=new int[v];

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for (int vertex = 0; vertex < v; ++vertex) {
            if (vertex == 0) {
                distance[vertex] = 0;
            } else {
                distance[vertex] = Integer.MAX_VALUE;
            }
            resultSet[vertex]=new ResultSet();
        }

        priorityQueue.offer(new Pair(distance[0],0));
        resultSet[0] =new ResultSet();
        resultSet[0].parent=-1;
        while (!priorityQueue.isEmpty()) {
            Pair smallestPair = priorityQueue.poll();
            mst[smallestPair.value]=true;
            for (Node adjacentVertex : this.adjacencyList.get(smallestPair.value)) {
                if (mst[adjacentVertex.vertex]==false) {
                    if (distance[adjacentVertex.vertex] >adjacentVertex.weight) {
                        priorityQueue.offer(new Pair(adjacentVertex.weight,adjacentVertex.vertex));
                        resultSet[adjacentVertex.vertex].parent=smallestPair.value;
                        resultSet[adjacentVertex.vertex].weight=adjacentVertex.weight;
                        distance[adjacentVertex.vertex] = adjacentVertex.weight;
                    }

                }
            }
        }

        System.out.println(resultSet);


    }
}