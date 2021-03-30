package DynamicProgramming;

import java.util.Scanner;

public class StairPathWithVar{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] path = new int[n];
        
        for(int i = 0; i < n; i++) {
            path[i] = sc.nextInt();
        }
        
        System.out.println(climbVariable(n,path));

        sc.close();
    }
    
    // we will start from end
    
    public static int climbVariable(int n,int path[]) {
        
        int[] dp = new int[n+1];
        
        dp[n] = 1;
        
        for (int i = n-1; i >= 0; i--) {
            
            for (int j = 1; j <= path[i] && j + i <= n; j++){
                dp[i] += dp[i+j];
            }
        }
        
        return dp[0];
    }
}