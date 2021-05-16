package DynamicProgramming;

import java.util.Scanner;

/**
 * FriendsPairing
 */
public class FriendsPairing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print(findPairs(n));
        sc.close();
    }

    private static int findPairs(int n) {
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2]*(i-1);
        }
        return dp[n];
    }
}