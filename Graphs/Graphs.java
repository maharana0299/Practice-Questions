import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graphs
 */
public class Graphs {

    class Vertex{

        HashMap<String,Integer> nbrs = new HashMap<>();
    }

    HashMap<String,Vertex> vertices = new HashMap<>();

    public int numVertex(){
        
        return this.vertices.size();
    }

    public void addVertex(String vname){
        
        Vertex vtx = new Vertex();
        vertices.put(vname, vtx);
    }

    public void removeVertex(String vname){
        
        Vertex vtx = vertices.get(vname);

        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for(String key : keys) {

            Vertex nbrVrtx = vertices.get(key);
            nbrVrtx.nbrs.remove(vname);
        }

        vertices.remove(vname);
    }

    public boolean containsVerteX(String vname){
        
        return this.vertices.containsKey(vname);
    }

    public int noOfEdges(){

        // calcluate total edges
        ArrayList<String> keys =  new ArrayList<>(vertices.keySet());
        int count = 0;
        for(String key : keys){
            Vertex vtx = vertices.get(key);
            count += vtx.nbrs.size();
        }

        count /= 2;
        return count;
    }

    public boolean conTainsEdge(String v1, String v2){
        
        Vertex  vx1 = vertices.get(v1);
        Vertex vx2 = vertices.get(v2);

        if(vx1 == null || vx2 == null || !vx1.nbrs.containsKey(v2)) {
            return false;
        } else {
            return true;
        }
    }

    public void addEdge(String v1, String v2, int wt){
        
        Vertex  vx1 = vertices.get(v1);
        Vertex vx2 = vertices.get(v2);

        if(vx1 == null || vx2 == null || vx1.nbrs.containsKey(v2)) {
            return ;
        } 

        vx1.nbrs.put(v2, wt);
        vx2.nbrs.put(v1, wt);
    }

    public void removeEdge(String v1, String v2){

        Vertex  vx1 = vertices.get(v1);
        Vertex vx2 = vertices.get(v2);

        if(vx1 == null || vx2 == null || !vx1.nbrs.containsKey(v2)) {
            return ;
        } 

        vx1.nbrs.remove(v2);
        vx2.nbrs.remove(v1);
    }

    public void display(){

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        System.out.println("----------------------------------------");
        for(String key : keys){

            Vertex vtx = vertices.get(key);
            System.out.println(key + " " + vtx.nbrs);
        }
        System.out.println("----------------------------------------");
    }

    public boolean hasPathBFS(String src, String dest){

        HashMap<String,Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;

        queue.add(sp);

        while(!queue.isEmpty()) {

            Pair rp = queue.remove();

            if(processed.containsKey(rp.vname)){
                // if already processed then process for next iteration
                continue;
            }
            //processed put
            processed.put(rp.vname, true);

            // check direct edge 
            if(conTainsEdge(rp.vname, dest)){
                System.out.println(rp.psf + dest);
                return true;
            }

            Vertex rpvtx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for(String nbr : nbrs) {
                if(!processed.containsKey(nbr)){
                    Pair mp = new Pair();
                    mp.vname = nbr;
                    mp.psf = rp.psf + nbr;

                    queue.add(mp);
                }
            }
        }

        return false;
    }

    public boolean dfsSearch(String src, String dest){

        HashMap<String,Boolean> processed = new HashMap<>();
        Stack<Pair> stack = new Stack<>();

        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;

        stack.push(sp);

        while(!stack.isEmpty()) {

            Pair rp = stack.pop();

            if(processed.containsKey(rp.vname)){
                // if already processed then process for next iteration
                continue;
            }
            //processed put
            processed.put(rp.vname, true);

            // check direct edge 
            if(conTainsEdge(rp.vname, dest)){
                System.out.println(rp.psf + dest);
                return true;
            }

            Vertex rpvtx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for(String nbr : nbrs) {
                if(!processed.containsKey(nbr)){
                    Pair mp = new Pair();
                    mp.vname = nbr;
                    mp.psf = rp.psf + nbr;

                    stack.push(mp);
                }
            }
        }

        return false;
    }

    public void bft() {

        HashMap<String,Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        for(String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            queue.add(sp);

            while(!queue.isEmpty()) {

                Pair rp = queue.remove();

                if(processed.containsKey(rp.vname)){
                    // if already processed then process for next iteration
                    continue;
                }
                //processed put
                processed.put(rp.vname, true);

                // check direct edge 
                // if(conTainsEdge(rp.vname, dest)){
                //     System.out.println(rp.psf + dest);
                //     return true;
                // }
                System.out.println(rp.vname + " " + rp.psf);

                Vertex rpvtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

                for(String nbr : nbrs) {
                    if(!processed.containsKey(nbr)){
                        Pair mp = new Pair();
                        mp.vname = nbr;
                        mp.psf = rp.psf + nbr;

                        queue.add(mp);
                    }
                }
            }
        }

    }

    public void dft(){
        HashMap<String,Boolean> processed = new HashMap<>();
        Stack<Pair> stack = new Stack<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        for(String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            stack.push(sp);

            while(!stack.isEmpty()) {

                Pair rp = stack.pop();

                if(processed.containsKey(rp.vname)){
                    // if already processed then process for next iteration
                    continue;
                }
                //processed put
                processed.put(rp.vname, true);

                // check direct edge 
                // if(conTainsEdge(rp.vname, dest)){
                //     System.out.println(rp.psf + dest);
                //     return true;
                // }
                System.out.println(rp.vname + " " + rp.psf);

                Vertex rpvtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

                for(String nbr : nbrs) {
                    if(!processed.containsKey(nbr)){
                        Pair mp = new Pair();
                        mp.vname = nbr;
                        mp.psf = rp.psf + nbr;

                        stack.push(mp);
                    }
                }
            }
        }

    }

    public boolean isCyclePresent() {

        HashMap<String,Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        for(String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            queue.add(sp);

            while(!queue.isEmpty()) {

                Pair rp = queue.remove();

                if(processed.containsKey(rp.vname)){
                    // if already processed then process for next iteration
                    return true;
                }
                //processed put
                processed.put(rp.vname, true);

                // check direct edge 
                // if(conTainsEdge(rp.vname, dest)){
                //     System.out.println(rp.psf + dest);
                //     return true;
                // }
                System.out.println(rp.vname + " " + rp.psf);

                Vertex rpvtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

                for(String nbr : nbrs) {
                    if(!processed.containsKey(nbr)){
                        Pair mp = new Pair();
                        mp.vname = nbr;
                        mp.psf = rp.psf + nbr;

                        queue.add(mp);
                    }
                }
            }
        }
        
        return false;
    }

    public boolean isConnected() {

        HashMap<String,Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        int count = 0;
        for(String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }

            count++;
            if(count == 2) {
                // visiting for 2nd time hence graph is disconnected
                return false;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            queue.add(sp);

            while(!queue.isEmpty()) {

                Pair rp = queue.remove();

                if(processed.containsKey(rp.vname)){
                    // if already processed then process for next iteration
                    continue;
                }
                //processed put
                processed.put(rp.vname, true);

                // check direct edge 
                // if(conTainsEdge(rp.vname, dest)){
                //     System.out.println(rp.psf + dest);
                //     return true;
                // }
                System.out.println(rp.vname + " " + rp.psf);

                Vertex rpvtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

                for(String nbr : nbrs) {
                    if(!processed.containsKey(nbr)){
                        Pair mp = new Pair();
                        mp.vname = nbr;
                        mp.psf = rp.psf + nbr;

                        queue.add(mp);
                    }
                }
            }
        }

        return true;
    }

    public boolean isTree() {

        return !isCyclePresent() && isConnected();
    }

    public ArrayList<ArrayList<String>> getConnectedComponents() {

        ArrayList<ArrayList<String>> compenetList = new ArrayList<>();
        HashMap<String,Boolean> processed = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        for(String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }

            ArrayList<String> componentStrings = new ArrayList<>();
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            queue.add(sp);

            while(!queue.isEmpty()) {

                Pair rp = queue.remove();

                if(processed.containsKey(rp.vname)){
                    // if already processed then process for next iteration
                    continue;
                }
                //processed put
                processed.put(rp.vname, true);

                // check direct edge 
                // if(conTainsEdge(rp.vname, dest)){
                //     System.out.println(rp.psf + dest);
                //     return true;
                // }
                componentStrings.add(rp.vname);

                Vertex rpvtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

                for(String nbr : nbrs) {
                    if(!processed.containsKey(nbr)){
                        Pair mp = new Pair();
                        mp.vname = nbr;
                        mp.psf = rp.psf + nbr;

                        queue.add(mp);
                    }
                }
            }

            compenetList.add(componentStrings);
        }
        
        return compenetList;
    }
    private class Pair{
        String vname;
        String psf;
    }
}