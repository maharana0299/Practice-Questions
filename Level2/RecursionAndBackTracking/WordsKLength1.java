import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WordsKLength1 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
        
        perm(0,ustr,0,k, new Character[k]);
    
    }
    
    public static void perm(int ci, String uniq,int sf, int ts, Character[] spots) {
        
        if(ci == uniq.length()) {
            
            if(sf == ts) {
                for(int i = 0; i < spots.length; i++){
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        
        for(int i = 0; i < ts; i++) {
            
            char ch = uniq.charAt(ci);
            if(spots[i] == null) {
                spots[i] = ch;
                perm(ci+1,uniq,sf+1,ts,spots);
                spots[i] = null;
            }
        }
        
        perm(ci+1,uniq,sf,ts,spots);
    }

}
