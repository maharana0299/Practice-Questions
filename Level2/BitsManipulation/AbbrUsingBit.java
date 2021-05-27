import java.util.*;

public class AbbrUsingBit {

    public static void solve(String str){
        
       int it = 1<<str.length();
       for(int i = 0; i < it; i++) {
           StringBuilder sb = new StringBuilder();
           int count = 0;
           
           for(int j = 0; j < str.length(); j++) {
               // bit analyes from other end
               int bit = str.length()-1-j;
               char ch = str.charAt(j);
               
               if((i & (1 << bit)) == 0) {
                   
                   if(count != 0) {
                       sb.append(count);
                       count = 0;
                   } 
                   
                   sb.append(ch);
               } else {
                   count++;
               }
           }
           
           if(count > 0) {
               sb.append(count);
           }
           
           System.out.println(sb);
       }
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
        scn.close();
    }
}