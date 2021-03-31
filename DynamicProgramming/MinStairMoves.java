package DynamicProgramming;

import java.util.Scanner;

public class MinStairMoves {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mv = new int[n];
        
        for (int i = 0 ; i < n; i++) {
            mv[i] = sc.nextInt();
        }
        
        System.out.println(climbWithMinMoves(n,mv) );

        sc.close();
    }
    
    public static int climbWithMinMoves(int n, int[] mv){
        
        Integer dp[] = new Integer[n+1];
        
        dp[n] = 0;
        
        for (int i = n-1; i >= 0; i--) {
            
            if(mv[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= mv[i] && j+i <= n; j++) {
                    if (dp[i+j] != null)
                        min = Math.min(min,dp[i+j]);
                }
                
                if (min != Integer.MAX_VALUE)
                    dp[i] = 1 + min;
                
            }
        }
        
        return dp[0];
    }

}