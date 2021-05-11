import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        // vx2.nbrs.put(v1, wt);
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
        // Map<String,PrimsPair> map = new HashMap<>();
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
        }
        
        return mst;
    }

    public Set<DijkPair> singleSourceShortesPathDijki(String s) {

        Set<String> visited = new HashSet<>();
        Set<DijkPair> ans = new HashSet<>();

        PriorityQueue<DijkPair> pq = new PriorityQueue<>();

        DijkPair mp = new DijkPair();
        mp.vname = s;
        mp.psf = s + "";
        mp.wsf = 0;
        pq.add(mp);

        while(!pq.isEmpty()) {

            DijkPair rm = pq.remove(); //removes min 

            if(visited.contains(rm.vname))
                continue;

            visited.add(rm.vname);
            ans.add(rm); // add to solution 

            for(String nbr : vertices.get(rm.vname).nbrs.keySet()) {

                if(visited.contains(nbr))
                    continue;
                
                DijkPair dijkPair = new DijkPair();
                dijkPair.vname = nbr;
                dijkPair.psf = rm.psf + " -> " + nbr;
                dijkPair.wsf = rm.wsf + vertices.get(rm.vname).nbrs.get(nbr); // wt

                pq.add(dijkPair); // add it to pq
            }
        }
        return ans;
    }

    public ArrayList<Edge> getAllEdges() {
        
        ArrayList<Edge> edges = new ArrayList<>();

        for(String vname : vertices.keySet()){

            Vertex vtx = vertices.get(vname);

            for(String nbr : vtx.nbrs.keySet()){

                Edge ep = new Edge(vname,nbr,vtx.nbrs.get(nbr));
                edges.add(ep);
            }
        }

        return edges;
    }

    public void kruskal() {

        ArrayList<Edge> edges = getAllEdges();
        Collections.sort(edges);
        DisJoinSet set = new DisJoinSet();

        // System.out.println(edges);

        // first step is to make-set for each vertex
        for(String vname : vertices.keySet()){
            set.makeSet(vname);
        }

        // traverse all edges
        for(Edge edge : edges) {

            
            String re1 = set.find(edge.src);
            String re2 = set.find(edge.dest);

            // if already present in same set then skip
            if(re1 == re2)
                continue;

            // if sets are disjoint then union 
            set.union(edge.src, edge.dest);
            
            //print edgePair
            System.out.println(edge);
            
        }
    }
    

    /**
     * This is for directed graph so remember to remove mulitple edges in add function
     * Can be used to detect negative wt cycle
     *  @param source
     * @return
     */
    public HashMap<String, Integer> bellmanFord(String source) {

        ArrayList<Edge> edges = getAllEdges();  // gettting all edges
        HashMap<String, Integer> resultMap = new HashMap<>();

        for(String vname : vertices.keySet()) {

            resultMap.put(vname, 10000); // initialize with infinity
            if(source.equals(vname))
                resultMap.put(vname, 0);
        }

        // relax every edge V-1 times

        for(int i = 1; i <= vertices.size(); i++) {

            for(Edge edge : edges) {

                int oc = resultMap.get(edge.dest);
                int nc = resultMap.get(edge.src) + edge.wt;

                if(oc > nc) {

                    if(i <= vertices.size()-1)
                    resultMap.put(edge.dest, nc); // Relax
                    else {
                        // it impleis negative wt sycle exist
                        System.out.println("Negative WT Cycle Deteced!!!");
                        return new HashMap<>();
                    }
                }
            }
        }
        return resultMap;
    }
    
    public void floyddWarshall() {

        int n = vertices.size();
        int[][] distanceMatrix = new int[n][n];
        
    }

    public class DisJoinSet {

        HashMap<String, Node> map = new HashMap<>();

        public void makeSet(String s) {

            Node n = new Node();
            n.data = s;
            n.parent = n;
            n.rank = 0; // initiallly zero

            map.put(s, n);
        }

        public void union(String v1, String v2) {

            v1 = find(v1);
            v2 = find(v2);

            if(v1 == v2)
                return ;
            else {
                
                Node n1 = map.get(v1);
                Node n2 = map.get(v2);

                if(n1.rank > n2.rank) {
                    n2.parent = n1;
                } else if(n1.rank == n2.rank ) {
                    n1.rank += 1;
                    n2.parent = n1;
                } else {
                    n1.parent = n2;
                }
            }
        }

        public String find(String vrtx) {
            return findSet(map.get(vrtx)).data;
        }

        private Node findSet(Node node){

            if(node == node.parent)
                return node;
            node.parent = findSet(node.parent); // for path compression;
            // return findSet(node.parent);
            return node.parent;
        }

        private class Node {

            Node parent;
            String data;
            int rank;
        }
    }

    private class Pair{
        
        String vname;
        String psf;

        Pair(){}
    }

    private class Edge implements Comparable<Edge>{

        String src;
        String dest;
        int wt;

        Edge(){}

        public Edge(String src, String dest, Integer wt) {
        
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Graphs.Edge o) {
            
            return this.wt - o.wt;
        }

        @Override
        public String toString() {
            
            return src + "-" + dest + ": " + wt; 
        }
    }

    public class DijkPair implements Comparable<DijkPair> {
        
        String vname;
        String psf;
        int wsf;

        DijkPair(){}

        DijkPair(String vname,String psf, int wsf) {
            this.psf = psf;
            this.vname = vname;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Graphs.DijkPair o) {
            return this.wsf-o.wsf;
        }

        @Override
        public String toString() {
            return vname + 
            // " : " + psf + 
            " : " + wsf;
        }
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