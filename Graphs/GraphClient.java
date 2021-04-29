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
        graph.addVertex("F");
        graph.addVertex("G");
        
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 21);
        graph.addEdge("B", "C", 22);
        graph.addEdge("C", "D", 21);
        graph.addEdge("D", "E", 34);
        graph.addEdge("E", "F", 34);
        graph.addEdge("E", "G", 34);
        graph.addEdge("F", "G", 11);

        graph.display();

        System.out.println(graph.noOfEdges());
        System.out.println(graph.conTainsEdge("A","C"));
        System.out.println(graph.numVertex());
        graph.removeEdge("A", "B");
        graph.addVertex("M");
        graph.addEdge("A", "M", 10);
        graph.display();

    }
}