import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
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
    
    public Graphs MSTprims() {

        Graphs mst = new Graphs();
        Map<String,PrimsPair> map = new HashMap<>();
        PriorityQueue<PrimsPair> heap = new PriorityQueue<>();
        Set<String> visitedKeys = new HashSet<>();
        // initializing
        // for(String key : vertices.keySet()) {

        //     PrimsPair np = new PrimsPair();
        //     np.vname = key;
        //     np.acqVrtx = null;
        //     np.cost = Integer.MAX_VALUE;

        //     heap.add(np);
        //     map.put(key,np);
        // }

        String vinit = vertices.keySet().iterator().next();
        PrimsPair pp = new PrimsPair(vinit,null);
        
        heap.add(pp);
        

        // till heap is not empty
        while(! heap.isEmpty()) {

            // remove a pair 
            PrimsPair rp = heap.remove();
            // map.remove(rp.vname); // also remove it from hashmap

            // if(map.containsKey(rp.vname))
            //     continue;
            if(visitedKeys.contains(rp.vname))
                continue;

            // map.put(rp.vname,rp); // marked visited
            visitedKeys.add(rp.vname);

            if(rp.acqVrtx == null) {
                mst.addVertex(rp.vname); // for base case
            } else {
                mst.addVertex(rp.vname);
                mst.addEdge(rp.vname, rp.acqVrtx, rp.cost);
            }

            // we can;t update the value easily and also change the priority 
            // so to ovwecome this problem, we will add the element in pq after updating its value
            // isntead of haspmap we can use sets
            for(String nbr : vertices.get(rp.vname).nbrs.keySet()) {

                // if(map.containsKey(nbr))
                if(visitedKeys.contains(nbr))
                    continue;
                
                    PrimsPair gp = new PrimsPair();
                    gp.vname = nbr;
                    gp.acqVrtx = rp.vname;
                    gp.cost = vertices.get(rp.vname).nbrs.get(nbr); // cost of nbr

                    heap.add(gp);
            }
            // for(String nbr : vertices.get(rp.vname).nbrs.keySet()) {

            //     // for pairs which are already there
            //     if(!map.containsKey(nbr)) {
            //         // oc 
            //         // int oc = map.get(nbr).cost;
            //         int nc = vertices.get(rp.vname).nbrs.get(nbr);
            //         // if(nc < oc){
                         
            //             // if old cost is greater then update
            //         PrimsPair gp = vertices.get(nbr);
            //         gp.vname = nbr;
            //         gp.acqVrtx = rp.vname;
            //         gp.cost = nc;
            //         heap.add(gp);
            //         // }
            //     }
            // }
        }
        
        return mst;
    }

    private class Pair{
        String vname;
        String psf;

        Pair(){}
    }

    private class PrimsPair implements Comparable<PrimsPair>{
        
        String acqVrtx;
        String vname;
        int cost;

        PrimsPair(String vname, String acqVrtx){
            
            this.vname = vname;
            this.acqVrtx = acqVrtx;
            this.cost = Integer.MAX_VALUE;
        }

        PrimsPair(){}

        // Implementing Comparable 
        @Override
        public int compareTo(PrimsPair o) {
            return this.cost-o.cost;
        }
    }
}