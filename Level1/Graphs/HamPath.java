package Graphs;

import java.util.*;

/**
 * HamPath
 */
public class HamPath {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> ed) { 
        
        HashMap<Integer,Edge> graph = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> edges = ed.get(i);
            
            int a = edges.get(0);
            int b = edges.get(1);
            
            addEdge(graph,a,b);
            addEdge(graph,b,a);
        }
        
        // for(Integer i : graph.keySet()) {
        //     System.out.println("s-" + graph.get(i).nbrs);
        // }
        
        Set<Integer> vis = new HashSet<>();
        
        for(Integer v : graph.keySet()) {
            
            checkHam(graph,v,vis,v,N);
        }
        return true;
    }
    
    boolean checkHam(HashMap<Integer,Edge> graph, int src, Set<Integer> vis, int o, int n) {
        
        if(vis.contains(src))
            return false;

        vis.add(src);

        if(vis.size() == n) {
            
            vis.remove(src);
            for(Integer nbr : graph.get(src).nbrs.keySet()) {
                if(nbr == o)
                    return false;
            }
            return true;
        }

        for(Integer nbr : graph.get(src).nbrs.keySet()) {

            if(vis.contains(nbr))
                continue;
            boolean isHamPath = checkHam(graph, nbr, vis, o,n);
            if(isHamPath) {
                vis.remove(src);
                return true;
            }
        }

        vis.remove(src);

        return false;
        
    }
    
    void addEdge(HashMap<Integer,Edge> graph, int a, int b) {
        
        if(graph.containsKey(a)) {
            
            Edge e = graph.get(a);
            e.nbrs.put(b,1);
        } else {
            
            Edge e = new Edge();
            e.v = a;
            e.nbrs.put(b,1);
            graph.put(a,e);
        }
    }
    
    class Edge {
        
        int v;
        HashMap<Integer,Integer>  nbrs = new HashMap<>();
    }
}