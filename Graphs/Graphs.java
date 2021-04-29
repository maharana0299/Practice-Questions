import java.util.ArrayList;
import java.util.HashMap;

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

}