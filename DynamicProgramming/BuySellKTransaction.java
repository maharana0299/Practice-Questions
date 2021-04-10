package DynamicProgramming;

import java.util.Scanner;

/**
 * BuySellKTransaction
 */
public class BuySellKTransaction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int ways = findMaxProfit(arr,n,k);
        System.out.println(ways);
        sc.close();
    }

    public static int findMaxProfitNaive(int[] arr, int n, int k) {
        
        int [][] dp = new int[k+1][n];
        for(int transaction = 0; transaction <= k; transaction++){   
            for(int day = 1; day < n; day++){

                int max = dp[transaction][day-1];

                for (int pd = 0; pd < day; pd++) {
                    int profitTilltm1 = dp[transaction-1][pd];

                    int pth = arr[day] - arr[pd];

                    if (profitTilltm1 + pth > max)
                        max = pth + profitTilltm1;
                }

                dp[transaction][day] = max;
            } 
        }
        return dp[k][n-1];
    }

    
    private static int findMaxProfit(int[] arr, int n, int k) {
        
        int [][] dp = new int[k+1][n];
        for(int transaction = 1; transaction <= k; transaction++){   
            
            int ptc = Integer.MIN_VALUE;
            
            for(int day = 1; day < n; day++){
                
                if (ptc < dp[transaction-1][day-1]-arr[day-1])
                    ptc = dp[transaction-1][day-1] - arr[day-1];
                    
                if (ptc + arr[day] > dp[transaction][day-1])
                   dp[transaction][day] = ptc + arr[day];
                else dp[transaction][day] = dp[transaction][day-1];
            } 
        }
        return dp[k][n-1];
    }
}