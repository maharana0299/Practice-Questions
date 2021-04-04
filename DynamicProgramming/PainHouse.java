package DynamicProgramming;

import java.util.Scanner;

/**
 * PainHouse
 */
public class PainHouse {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HousePair[] arr = new HousePair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new HousePair();
            arr[i].wR = sc.nextInt();
            arr[i].wB = sc.nextInt();
            arr[i].wG = sc.nextInt();
        }
        
        int min = findMinCost(arr,n);
        System.out.println(min);
        sc.close();
    }
    public static class HousePair {
        int wR;
        int wB;
        int wG;
    }
    public static int findMinCost(HousePair[] hp, int n) {
        
        int dp[][] = new int[n][3];
        dp[0][0] = hp[0].wR;
        dp[0][1] = hp[0].wB;
        dp[0][2] = hp[0].wG;
        
        for (int i = 1; i < n; i++) {
                dp[i][0] = hp[i].wR + Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = hp[i].wB + Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = hp[i].wG + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}