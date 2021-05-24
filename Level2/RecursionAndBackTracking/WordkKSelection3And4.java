// package RecursionAndBackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * WordkKSelection3
 */
public class WordkKSelection3And4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
          if (unique.containsKey(ch) == false) {
            unique.put(ch, 1);
            set.add(ch);
            ustr += ch;
          } else {
            unique.put(ch, unique.get(ch) + 1);
          }
        }
        combK(1,k,ustr,unique,"",0);
      }
      
      // placed spots on level
      // each spot has option to select last selected charactrer if possible or to select next character
      // this is an combination problem hence we are not exploring all the other options
      public static void combK(int ci, int ts, String str, HashMap<Character, Integer> map, String asf, int lc) {
          
          if(ci > ts) {
              System.out.println(asf);
              return;
          }
          
          for(int i = lc; i < str.length(); i++) {
              
              char ch = str.charAt(i);
              int freq = map.get(ch);
              
              if(freq > 0) {
                  map.put(ch,freq-1);
                  combK(ci+1,ts,str,map,asf+ch,i);
                  map.put(ch,freq);
              }
          }
      }

}

class WorkKSel3 {
    
    public static void generateSelection(int cs, int ts, String ustr, HashMap<Character, Integer> unique, int ls, String asf) {
        if (cs > ts) {
          System.out.println(asf);
          return;
        }
    
        for (int i = ls; i < ustr.length(); i++) {
          char ch = ustr.charAt(i);
    
          if (unique.get(ch) > 0) {
            unique.put(ch, unique.get(ch) - 1);
            generateSelection(cs + 1, ts, ustr, unique, i, asf + ch);
            unique.put(ch, unique.get(ch) + 1);
          }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.containsKey(ch) == false) {
            unique.put(ch, 1);
            ustr += ch;
          } else {
            unique.put(ch, unique.get(ch) + 1);
          }
        }
    
        generateSelection(1, k, ustr, unique, 0, "");
      }
}