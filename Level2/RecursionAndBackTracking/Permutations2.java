import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutations2 {
    
    public static void permutations(int cb, int tb, int[] visited, int ssf, int ts, String asf){
    
        if(cb > tb) {
            
            if(ssf == ts) {
                System.out.println(asf);
            }
            
            return;
        }
        
        for(int i = 0; i < ts; i++) {
            
            if(visited[i] == 0){
                
                visited[i] = 1;
                permutations(cb+1,tb,visited,ssf+1,ts,asf + (i+1));
                visited[i] = 0;
            }
        }
        
        permutations(cb+1,tb,visited,ssf,ts,asf + 0);
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
      }
    
}
