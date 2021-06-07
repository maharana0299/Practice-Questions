import java.util.*;

public class LPSCountDistinct {
    
    public class Main{
    
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            
            long countDistinct = cdss(str.toCharArray());
            
            System.out.println(countDistinct);
            scn.close();
        }
        
        public static long cdss(char[] s) {
            
            // dp stores the count of distict subsequence for n length 
            long dp[] = new long[s.length+1];
            dp[0] = 1;
            
            // HashMap of lastOccurance 
            Map<Character,Integer> lo = new HashMap<>();
            
            // for dp[i], the character will be at s[i-1] as dp[0] stores the occ or "" and dp[1] stores the count of subseq of s[0] and so onr
            for(int i = 1; i < dp.length; i++) {
                
                dp[i] = 2 * dp[i-1]; // 2 options -> come or not 
                
                if(lo.containsKey(s[i-1])) {
                    // subtract the ones, which were already made
                    dp[i] = dp[i] - dp[lo.get(s[i-1]) - 1];
                }
                
                lo.put(s[i-1],i); // putting last occ
            }
            
            return dp[s.length]-1;
        }
        
        
    }
}
