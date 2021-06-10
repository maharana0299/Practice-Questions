import java.util.*;

public class CatlanNumberCountValley{

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int ways = countValleys(n);
        System.out.println(ways);
    }
    
    static int countValleys(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            
            int inside = i-1;
            int outside = 0;
            
            while(inside >= 0) {
                
                dp[i] += dp[outside] * dp[inside];
                inside--;
                outside++;
            }
        }
        
        return dp[n];
        
    }

}