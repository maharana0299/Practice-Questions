package Graphs;

import java.io.*;
import java.util.*;

public class PrimsAlgo {
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

      primsAlgo(graph);
    }

    private static void primsAlgo(ArrayList<Edge>[] graph) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] visited = new boolean[graph.length];

        while(!pq.isEmpty()) {

            Pair mp = pq.remove();

            if(visited[mp.vname])
                continue;
            
            visited[mp.vname] = true;

            if(mp.aqvrtx != -1) {
                System.out.println(mp.toString());
            }

            for(Edge e : graph[mp.vname]) {

                if(visited[e.nbr])
                    continue;
                pq.add(new Pair(e.nbr,mp.vname,e.wt));
            }
        }
    }

    static class Pair implements Comparable<Pair>{

        int vname;
        int aqvrtx;
        int wt;

        public Pair(int vname, int aq, int wt) {
            this.aqvrtx = aq;
            this.vname = vname;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            
            return this.wt-o.wt;
        }

        @Override
        public String toString() {
            return "[" + this.vname + "-" + this.aqvrtx + "@" + this.wt + "]";
        }
    }
}