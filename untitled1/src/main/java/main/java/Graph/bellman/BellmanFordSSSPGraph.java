package main.java.Graph.bellman;

public class BellmanFordSSSPGraph {
    static main.java.Graph.bellman.DirectedWeightedGraph directedWeightedGraph =new main.java.Graph.bellman.DirectedWeightedGraph(6);
    public static void main(String[] args) {
        directedWeightedGraph.addEdge(0,1, 4);
        directedWeightedGraph.addEdge(0,2, 2);
        directedWeightedGraph.addEdge(1,4, 3);

        directedWeightedGraph.addEdge(2,3, 2);

        directedWeightedGraph.addEdge(2,5, 4);
        directedWeightedGraph.addEdge(3,4, 3);
        directedWeightedGraph.addEdge(3,5, 1);
        directedWeightedGraph.addEdge(4,5, 1);


        directedWeightedGraph.bellmanFord(0, 4);

    }
}
