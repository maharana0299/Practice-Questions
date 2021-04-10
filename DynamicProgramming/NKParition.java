package DynamicProgramming;

import java.util.Scanner;

/**
 * NKParition
 */
public class NKParition {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long ways = findWays(n,k);
        
        System.out.println(ways);
        sc.close();
    }
    
    public static long findWays(int n, int k){
       
        long[][] dp = new long[k+1][n+1];
        
        if(n == 0 || k == 0 || n < k)
            return 0;
        for(int t = 1; t <= k; t++){
            for(int p = 1; p <= n; p++) {
                
                if( p < t) {
                    dp[t][p] = 0;
                } else if (p == t) {
                    dp[t][p] = 1; 
                } else {
                    dp[t][p] = dp[t-1][p-1] + dp[t][p-1]*t;
                }
            }
        }
        return dp[k][n];
    }

    public static long findWaysRecursion(int n, int k){
        
        if(n < k || n == 0 || k == 0)
         return 0;
         
         if (n == k)
             return 1;
         
         return  k*findWaysRecursion(n-1,k) + findWaysRecursion(n-1,k-1);
    }
}