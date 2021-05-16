package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * IterativeDFS
 */
public class IterativeDFS {

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
  
        dfs(src,graph);  
    }

    private static void dfs(int src, ArrayList<IterativeDFS.Edge>[] graph) {

        Stack<Pair> st = new Stack<>();
        boolean visisted[] = new boolean[graph.length];
        st.push(new Pair(src,src+""));

        while(!st.isEmpty()){

            Pair mp = st.pop();

            if(visisted[mp.vname])
                continue;
            
            visisted[mp.vname] = true;
            System.out.println(mp.vname + "@" + mp.psf);
            for(Edge e : graph[mp.vname]){
                if(visisted[e.nbr])
                    continue;
                st.push(new Pair(e.nbr,mp.psf+e.nbr));
            }
        }
    }

    private static class Pair {
        int vname;
        String psf;

        Pair(int vname, String psf){
            this.vname = vname;
            this.psf = psf;
        }
    } 
    
}