package Graphs;

import java.io.*;
import java.util.*;

public class HamiltonianCycle {
    
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
        
        int src = Integer.parseInt(br.readLine());
        
        // cycls with * and paths with .
        
        traverse(graph,src,new boolean[graph.length],src + "",src);
   }
   
   public static void traverse(ArrayList<Edge>[] graph, int src, boolean visited[], String psf, int starting){
       
       // if it contains direct edge then it is hamiltonian cycle
      
        if(psf.length() == visited.length) {
         // ie all are visited 
         String a = ".";
         for(Edge e : graph[src]) {
            if(e.nbr == starting){
               a = "*";
               break;
            }
         }
         System.out.println(psf+a);
         return;
      }
      visited[src] = true;
      
      for(Edge e : graph[src]) {
         
         if(!visited[e.nbr]){
            traverse(graph, e.nbr, visited, psf+e.nbr,starting);   
         }
      }
      visited[src] = false;
   }
}