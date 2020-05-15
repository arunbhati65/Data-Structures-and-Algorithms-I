package main.java.Graph.prims;

public class Prims {
    static WeightedGraph weightedGraph=new WeightedGraph(9);
    public static void main(String[] args) {
       weightedGraph.addEdge( 0, 1, 4);
       weightedGraph.addEdge( 0, 7, 8);
       weightedGraph.addEdge( 1, 2, 8);
       weightedGraph.addEdge( 1, 7, 11);
       weightedGraph.addEdge( 2, 3, 7);
       weightedGraph.addEdge( 2, 8, 2);
       weightedGraph.addEdge( 2, 5, 4);
       weightedGraph.addEdge( 3, 4, 9);
       weightedGraph.addEdge( 3, 5, 14);
       weightedGraph.addEdge( 4, 5, 10);
       weightedGraph.addEdge( 5, 6, 2);
       weightedGraph.addEdge( 6, 7, 1);
       weightedGraph.addEdge( 6, 8, 6);
       weightedGraph.addEdge( 7, 8, 7);


        weightedGraph.prims_mst();

    }
}
