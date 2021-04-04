package DynamicProgramming;

import java.util.Scanner;

/**
 * TilingWith21
 */
public class TilingWith21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        System.out.println(calculateNoOfWaysToTile(n));
        sc.close();
    }

    private static int calculateNoOfWaysToTile(int n) {
        
        // infinite supply of 2*1 tile
        // area is nx2
        
        int dp[] = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}