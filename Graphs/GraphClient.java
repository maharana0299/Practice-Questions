package Graphs;

/**
 * GraphClient
 */
public class GraphClient {

    

    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        // graph.addVertex("F");
        // graph.addVertex("G");
        // graph.addVertex("L");
        // graph.addVertex("P");

        // graph.addEdge("L", "P", 12);
        // graph.addEdge("A", "B", 2);
        // graph.addEdge("A", "D", 6);
        // graph.addEdge("B", "C", 3);
        // graph.addEdge("C", "D", 1);
        // graph.addEdge("D", "E", 7);
        // graph.addEdge("E", "F", 5);
        // graph.addEdge("E", "G", 7) ;
        // graph.addEdge("F", "G", 4);

        graph.addEdge("A", "B", 8);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "D", -3);
        graph.addEdge("D", "E", 4);
        graph.addEdge("E", "B", 1) ;
        graph.addEdge("B", "E", 4);

        graph.display();

        // System.out.println(graph.noOfEdges());
        // System.out.println(graph.conTainsEdge("A","C"));
        // System.out.println(graph.numVertex());
        // graph.removeEdge("E", "D");
        // graph.addVertex("M");
        // graph.addEdge("A", "M", 10);

        // System.out.println(graph.dfsSearch("A", "F"));
        // graph.display();
        // graph.dft();
        // System.out.println();
        // graph.MSTprims().display();

        // System.out.println(graph.singleSourceShortesPathDijki("A").toString());
        // graph.kruskal();
        // graph.MSTprims().display();

        System.out.println(graph.bellmanFord("A"));
    }
}