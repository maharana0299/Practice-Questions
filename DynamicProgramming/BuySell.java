package DynamicProgramming;

import java.util.Scanner;

/**
 * BuySell
 */
public class BuySell {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findWays(arr,n));
        sc.close();
    }

    private static int findWays(int[] arr, int n) {
        int[] dp = new int[n];

        dp[0] = 0;
        int leastDay = arr[0];

        for (int i = 1; i < dp.length; i++) {
            
            if (arr[i] < leastDay)
                leastDay = arr[i];

            dp[i] = Math.max(dp[i-1], arr[i]-leastDay);
        }

        return dp[n-1];
    }
}