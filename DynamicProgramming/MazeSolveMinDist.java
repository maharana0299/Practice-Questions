package DynamicProgramming;

import java.util.Scanner;

public class MazeSolveMinDist {
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
        
        int minCost = calculateMinCostMaze(arr);
        System.out.println(minCost);

        sc.close();
    }
    
    public static int calculateMinCostMaze(int[][] cost) {
        
        int n = cost.length;
        int m = cost[0].length;
        
        int dp[][] = new int[n][m];
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                
                if (i == n-1 && j == m-1) {
                    dp[i][j] = cost[i][j];
                } else if (i == n-1) {
                    dp[i][j] = cost[i][j] + dp[i][j+1];
                } else if (j == m-1) {
                    dp[i][j] = cost[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = cost[i][j] + Math.min(
                        dp[i+1][j],dp[i][j+1]
                        );
                }
            }
        }
        
        return dp[0][0];
    }

}