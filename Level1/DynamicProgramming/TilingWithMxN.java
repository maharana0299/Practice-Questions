package DynamicProgramming;

import java.util.Scanner;

/**
 * TilingWithMxN
 */
public class TilingWithMxN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(findTilingWays(n,m));

        sc.close();
    }

    private static Integer findTilingWays(int n, int m) {

        if (n < m)
            return 1;
        
        int dp [] = new int[n+1];
        
        for (int i = 1; i < dp.length; i++) {
            if (i < m) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        return null;
    }
}