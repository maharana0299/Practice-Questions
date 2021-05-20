import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Wordbreak1 {
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
      
        if(cs > ts) {
            
            System.out.println(asf);
            return;
        }
        
        // taking boxes on level 
        for(Character ch : fmap.keySet()) {
            
            Integer i = fmap.get(ch);
            
            if(i > 0) {
                fmap.put(ch,i-1);
                generateWords(cs+1,ts,fmap,asf + ch);
                fmap.put(ch,i);
            }
            
        }
    }
  
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
  
      HashMap<Character, Integer> fmap = new HashMap<>();
      for(char ch: str.toCharArray()){
        if(fmap.containsKey(ch)){
          fmap.put(ch, fmap.get(ch) + 1);
        } else {
          fmap.put(ch, 1);
        }
      }
  
      generateWords(1, str.length(), fmap, "");
    }
}
