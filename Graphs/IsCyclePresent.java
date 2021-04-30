import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * IsCyclePresent
 */
public class IsCyclePresent {

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
  
        boolean isCycle = isgraphCyclic(graph);
        System.out.println(isCycle);
     }

    private static boolean isgraphCyclic(ArrayList<Edge>[] graph) {

        // using bfs 
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        for(int src = 0; src < graph.length; src++) {
            
            if(visited[src])
                continue;
                
            Pair p = new Pair(src,src+"");
            queue.add(p);
                while(!queue.isEmpty()) {
    
                p = queue.remove();
    
                if(visited[p.vname]){
                    return true;
                }
    
                // System.out.println(p.vname + "@" + p.psf);
    
                visited[p.vname] = true;
    
                for(Edge e : graph[p.vname]) {
    
                    if(visited[e.nbr])
                        continue;
                
                    Pair np = new Pair();
                    np.vname = e.nbr;
                    np.psf = p.psf + e.nbr;
                    queue.add(np);
                }
            }
        }

        return false;
    }
}

class Pair {
    public int vname;
    public String psf;

    public Pair(){}

    public Pair(int vname, String psf) {
        this.vname = vname;
        this.psf = psf;
    }
}