import java.io.*;
import java.util.*;

public class IsGraphBipartite {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

     boolean isB = isByPartite(graph);
        System.out.println(isB);
     }

    private static boolean isByPartite(ArrayList<Edge>[] graph) {

        // using bfs 
        int[] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        
        for(int src = 0; src < graph.length; src++) {
            if(visited[src] == -1){
                
                boolean isBip = checkComp(graph, src, visited);
                if(!isBip)
                    return false;
            }
        }
        
        return true;
    }
    
    public static boolean checkComp(ArrayList<Edge>[] graph, int src, int[] visited) {
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(src,src+"",0)); // initial level 0
        
        while(!queue.isEmpty()){
            
            Pair rm = queue.remove();
            if(visited[rm.vname] != -1) {
                // check if it is visiting from same levwl or not
                if(rm.level != visited[rm.vname]) {
                    // if visiting in diffferent level, ie odd cycle 
                    return false;
                }
            } else {
                visited[rm.vname] = rm.level;
            }
            
            for(Edge e :graph[rm.vname]) {
                
                if(visited[e.nbr] == -1) {
                    queue.add(new Pair(e.nbr,rm.psf+e.nbr,rm.level+1));
                }
            }
        }
        
        return true;
    }
}

class Pair {
    public int vname;
    public String psf;
    public int level;
    
    public Pair(){}

    public Pair(int vname, String psf, int level) {
        this.vname = vname;
        this.psf = psf;
        this.level = level;
    }
}