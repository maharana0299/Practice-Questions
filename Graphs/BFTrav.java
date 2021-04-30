import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFTrav
 */
public class BFTrav {

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
  
        bft(graph,src);
     }

    private static void bft(ArrayList<Edge>[] graph, int src) {

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        Pair p = new Pair(src,src+"");
        queue.add(p);

        while(!queue.isEmpty()) {

            p = queue.remove();

            if(visited[p.vname]){
                continue;
            }

            System.out.println(p.vname + "@" + p.psf);

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

    static class Pair {

        int vname;
        String psf;

        public Pair(){}

        public Pair(int vname, String psf) {
            this.vname = vname;
            this.psf = psf;
        }
        
    }
}