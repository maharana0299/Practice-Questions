import java.util.*;

public class CatlanNumberCirclesAndChords {

    public static long NumberOfChords(int n){
        
        long dp[] = new long[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            
            int in = i-1;
            int out = 0;
            
            while(in >= 0) {
                
                dp[i] += dp[in]*dp[out];
                in--;
                out++;
            }
        }
        
        return dp[n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}