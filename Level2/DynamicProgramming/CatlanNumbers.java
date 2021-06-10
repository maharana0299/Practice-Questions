import java.util.*;

public class CatlanNumbers{

    /**
     * This is very important
     * There are many apps of catlan number 
     * Some of it are....
     * 1) OBST Given an integer n, return the number of structurally 
     *      unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int catlanNo = findCatlanNumber(n);
        System.out.println(catlanNo);
    }
    
    static int findCatlanNumber(int n) {
        
        // storing catlan no of n 
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i - j - 1];
            }
        }
        
        return dp[n];
    }

}