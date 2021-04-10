package DynamicProgramming;

import java.util.Scanner;

public class CoinRepCom {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coinCount = new int[n];
        
        for(int i = 0; i < n; i++) {
            coinCount[i] = sc.nextInt();
        }
        
        int amt = sc.nextInt();
        int com = findComb(coinCount,amt);
        
        System.out.println(com);
        sc.close();
    }
    
    public static int findComb(int[] nums, int tar) {
        
        int dp[][] = new int[nums.length+1][tar+1];
        
        int n = nums.length;
        int m = tar;
        
        for(int i = 0; i <= n; i++) 
            dp[i][0] = 1;
        
        // for (int i = 0; i <= tar; i++) 
        //     dp[0][i] = 1;
            
        dp[0][0] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= tar; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] <= j ) {
                    // this is because same comnbination can be used as many times we want
                    dp[i][j] = dp[i][j] + dp[i][j - nums[i-1]];
                    // System.out.println(dp[i-1][j-nums[i-1]] + " " + dp[i][j-nums[i-1]]);
                }
            }
        }
        return dp[n][m];
    }

    // another method 

    public static int comb2(int[] coins, int amt) {
        int n = coins.length;
        int [] dp = new int[amt+1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amt; j++) {
                if (coins[i-1] <= j ) {
                    dp[j] += dp[j- coins[i-1]];
                }
            }
        }

        return dp[amt];
    }
}