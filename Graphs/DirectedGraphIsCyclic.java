package Graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * DirectedGraphIsCyclic
 * We have to remember that if backedge is present during traversal then it is cyclic directed graph
 * This same question can also be done using topological sorting, ie, if it is not possible to topoplogically sort then it is a cyclic directed graph
 */
public class DirectedGraphIsCyclic {

    /**
     * 0 -> forward edges, ie, unvisited edges in simple term
     * 1 -> back edges
     * 2 -> visited edges
     */

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int visited[] = new int[V];

        for(int vertex = 0; vertex < V; vertex++) {
            if(isCyclicDirected(adj,vertex,visited))
                return true;
        }

        return false;

    }

    private boolean isCyclicDirected(ArrayList<ArrayList<Integer>> adj, int vertex, int[] visited) {

        Stack<Pair> st = new Stack<>();

        Pair p = new Pair(vertex,adj.get(vertex).size());
        
        st.push(p);
        
        while(!st.isEmpty()) {

            p = st.peek();

            if(visited[p.vname] == 2 || p.childs == 0) {
                // if vertex is visited or child is zero 
                st.pop(); // pop out the vertex
                visited[p.vname] = 2; // mark visited if not done already
            } else {

                visited[p.vname] = 1; // going to be an ansestor
                int nbr = adj.get(p.vname).get(p.childs-1);

                if(visited[nbr] == 1) {
                    // if nbr is currently an ascestor of the dsf vertex
                    return true;
                } else if (visited[nbr] == 0){
                    st.push(new Pair(nbr,adj.get(nbr).size()));
                } 
                p.childs -= 1;
                // }
            }
        }

        return false;
    }

    static class Pair {

        int vname;
        int childs;

        Pair(int vname, int childs) {

            this.vname = vname;
            this.childs = childs;
        }
    }
}