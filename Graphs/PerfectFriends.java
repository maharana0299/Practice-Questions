import java.util.ArrayList;
import java.util.Scanner;

/**
 * PerfectFriends
 */
public class PerfectFriends {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studenstsNo = sc.nextInt();
        int kClubs = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[studenstsNo];

        for(int i = 0; i < studenstsNo; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < kClubs; i++){
            Edge e = new Edge();
            e.src = sc.nextInt();
            e.nbr = sc.nextInt();

            graph[e.src].add(e);
            graph[e.nbr].add(new Edge(e.nbr,e.src));
        }

        ArrayList<ArrayList<Integer>> conncectedComponents = new ArrayList<>();

        boolean[] visited = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                ArrayList<Integer> ls = new ArrayList<>();
                drawTree(graph,i,ls,visited);
                conncectedComponents.add(ls);
            }
        }
        
        // System.out.println(conncectedComponents);

        int pairs = 0;
        // find all possible permutations
        for(int i = 0; i < conncectedComponents.size(); i++){
            for(int j = i+1; j < conncectedComponents.size(); j++) {
                pairs += conncectedComponents.get(i).size()*conncectedComponents.get(j).size();
            }
        }

        System.out.println(pairs);

        sc.close();
    }

    private static void drawTree(ArrayList<PerfectFriends.Edge>[] graph, int i, ArrayList<Integer> ls, boolean[] visited) {

        if(visited[i])
            return;

        visited[i] = true;
        ls.add(i);
        for(Edge e : graph[i]) {
            drawTree(graph, e.nbr, ls, visited);
        }
        
    }

    
    static class Edge {
        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
        public Edge() {
        }
        int src;
        int nbr;
    }
}