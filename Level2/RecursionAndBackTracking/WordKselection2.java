import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordKselection2 {
    
    public static void main(String[] args){
      
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int k =sc.nextInt();
        sc.close();
        
        Set<Character> set = new HashSet<>();
        String d = "";
        for(int i = 0; i < s.length(); i++) {
              char ch = s.charAt(i);
              if(set.contains(ch))
                  continue;
              set.add(ch);
              d += ch;
        }
        
          printOp(d,0,k,-1,"");
      }
      
      public static void printOp(String dis, int cs, int tot, int lc, String asf) {
          
          if(cs == tot) {
              System.out.println(asf);
              return;
          }
          
          
          for(int i = lc + 1; i < dis.length(); i++) {
              char ch = dis.charAt(i);
              printOp(dis,cs+1,tot,i,asf+ch);
          }
      }
  
}
