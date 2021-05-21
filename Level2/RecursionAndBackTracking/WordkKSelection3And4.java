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
        
        combk2(0, str, set, 0, k, new Character[k], -1);
        System.out.println("______________________________________");
        combK(1,k,ustr,unique,"",0);
      }
      
      // placed spots on level
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

    public static void combk2(int ci, String word, HashSet<Character> set, int fs, int ts, Character[] spots, int lf) {

        if(ci == word.length()) {

            if(ts == fs) {
                for(char ch : spots){
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }
        char ch = word.charAt(ci);

        if(set.contains(ch)) {
            for(int i = lf+1; i < ts; i++) {
                spots[i] = ch;
                combk2(ci+1, word, set, fs+1, ts, spots, i);
                spots[i] = null;
            }
        }

        if(set.contains(ch)){
            set.remove(ch);
        }
        combk2(ci+1, word, set, fs, ts, spots, lf);

        set.add(ch);
    }
}