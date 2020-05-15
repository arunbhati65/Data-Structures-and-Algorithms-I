package main.java.Graph.dijikstra;

public class DijikstraSSSPGraph {
    static WeightedGraph weightedGraph=new WeightedGraph(6);
    public static void main(String[] args) {
        weightedGraph.addEdge(0,1, 4);
        weightedGraph.addEdge(0,2, 2);
        weightedGraph.addEdge(1,4, 3);

        weightedGraph.addEdge(2,3, 2);

        weightedGraph.addEdge(2,5, 4);
        weightedGraph.addEdge(3,4, 3);
        weightedGraph.addEdge(3,5, 1);
        weightedGraph.addEdge(4,5, 1);


        weightedGraph.dijkstra(0, 4);

    }
}
