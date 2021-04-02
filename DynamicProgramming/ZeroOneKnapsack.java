package DynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        } 
        int c = sc.nextInt();
        
        // lets memoize it 
        int dp[][] = new int[n+1][c+1];

        for(int i = 0; i < n + 1; i++)  
            for(int j = 0; j < c + 1; j++)  
                dp[i][j] = -1; 

        int cap = solveKnapsack(val,wt,n,c);
        
        System.out.println(cap);
        sc.close();
    }
    
    // either include or exclude
    public static int solveKnapsack(int[] val, int[] wt, int n, int lim) {
            
        if (lim == 0 || n == 0)
            return 0;
        if (wt[n - 1] > lim)
            return solveKnapsack(val,wt,n-1,lim);
        int a = val[n-1] + solveKnapsack(val,wt,n-1,lim-wt[n-1]);
        int b = solveKnapsack(val,wt,n-1,lim);
        return Math.max(a,b);
    }

    /**
     * Using Memoization
     */
    public static int solveKnapsack(int[] val, int[] wt, int n, int lim,int[][] dp) {
            
        if (lim == 0 || n == 0)
            return 0;
            
        if (dp[n][lim] != -1)
            return dp[n][lim];
        if (wt[n - 1] > lim)
            return dp[n][lim] = solveKnapsack(val,wt,n-1,lim,dp);
           
        int a = val[n-1] + solveKnapsack(val,wt,n-1,lim-wt[n-1],dp);
        int b = solveKnapsack(val,wt,n-1,lim,dp);

        dp[n][lim] =  Math.max(a,b);

        return dp[n][lim];
    }

    public static int knapsack(int val[], int wt[], int W){
        
        int dp[][] = new int[val.length + 1][W+1];
        
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= W; j++) {
                
                if (wt[i-1] <= j ) {
                    dp[i][j] = Math.max(
                        val[i-1] + dp[i-1][j-wt[i-1]],
                        dp[i-1][j]
                        );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[val.length][W];
    }

    public static int unboundedKnapsackV2(int W, int[] val, int[] wt) {
        int dp[] = new int[W+1];
        
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= W; j++) {
                
                if (wt[i-1] <= j ) {
                    dp[j] = Math.max(
                        val[i-1] + dp[j-wt[i-1]],
                        dp[j]
                        );
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        
        return dp[W];
    }
}