package DynamicProgramming;

import java.util.Scanner;

public class GoldMineProblem {
    public static void main(String[] args) throws Exception {
            
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int max = calculateGoldMine(arr);
        System.out.println(max);
        sc.close();
    }
    
    public static int calculateGoldMine(int[][] cost) {
        
        int n = cost.length;
        int m = cost[0].length;
        int dp[][] = new int[n][m];
        int max[] = new int[m];
        
        for (int j= m-1; j >= 0; j--) {
            int maxs = -100;
            for (int i = n-1; i >= 0; i--) {
                
                if (j == m-1) {
                    dp[i][j] = cost[i][j];
                } else  if (i ==  n-1 ){
                  dp[i][j] = cost[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);  
                } else if(i == 0) {
                    dp[i][j] = cost[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                } else {
                    dp[i][j] = cost[i][j] + Math.max(
                        dp[i][j+1], Math.max(dp[i+1][j+1],
                        dp[i-1][j+1])
                        );
                }
                
                if (dp[i][j] > maxs) 
                    maxs = dp[i][j];
            }
            max[j] = maxs;
         }
        
        return max[0];
    }

}