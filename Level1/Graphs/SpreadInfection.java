package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SpreadInfection
 * BFS Traversal till th level 
 */
public class SpreadInfection {

    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        
        int noOfPeople = spreadInfection(graph, src, t);
        System.out.println(noOfPeople);
    }

    private static int spreadInfection(ArrayList<Edge>[] graph, int src, int t) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,src+"",1));
        int count = 0;
        boolean[] visited = new boolean[graph.length];

        while(!queue.isEmpty()) {

            Pair mp = queue.remove();
            if(visited[mp.vname]){
                continue;
            }
            
            if(mp.level > t) {
                break;
            }
            
            count++;
            visited[mp.vname] = true;
    
            for(Edge e : graph[mp.vname]) {
                if(!visited[e.nbr]) {
                    queue.add(new Pair(e.nbr, mp.psf+e.nbr,mp.level+1));
                } 
            }
        }
        return count;
    }

    static class Pair {
    
        int vname;
        String psf;
        int level;
    
        Pair(){}
    
        public Pair(int vname, String psf, int level) {
            
            this.vname = vname;
            this.psf = psf;
            this.level = level;
        }
    }
  
}