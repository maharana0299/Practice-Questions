package DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int wt[],val[];

        wt = new int[n];
        val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int W = sc.nextInt();

        int max = unboundedKnapsack(W,val,wt);
        System.out.println(max);
        sc.close();
    }

    private static int unboundedKnapsack(int w, int[] val, int[] wt) {
        int dp[] = new int[w+1];
        dp[0] = 0;

        for(int i = 1; i <= val.length; i++ ) {
            for(int j = 1; j <= w; j++) {
                
                if (j - val[i-1] >= 0) {
                    dp[j] = Math.max(dp[j],dp[j - val[i-1]]);
                }
            }
        }
        return dp[w];
    }
}