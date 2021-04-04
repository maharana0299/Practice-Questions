package DynamicProgramming;

import java.util.Scanner;

import jdk.vm.ci.meta.Assumptions.LeafType;

/**
 * PainWithMany
 */
public class PainWithMany {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[][] = new int[n][k];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int minCost = colorWithMin(arr,n,k);

        System.out.println(minCost);
    }

    private static int colorWithMin(int[][] arr, int n, int k) {

        int dp[][] = new int[n][k];

        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j];

            if (arr[0][j] <= least) {
                secondLeast = least;
                least = arr[0][j];
            } else if (arr[0][j] <= secondLeast) {
                secondLeast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int l1 = Integer.MAX_VALUE;
            int sl1 = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++) {
                
                dp[i][j] = arr[i][j];

                if (least == dp[i-1][j])
                    dp[i][j] += secondLeast;
                else dp[i][j] += least;


                if (dp[i][j] <= l1) {
                    sl1 = l1;
                    l1 = dp[i][j];
                } else if (dp[i][j] <= sl1) {
                    sl1 = dp[i][j];
                }
            }

            least = l1;
            secondLeast = sl1;
        }
        return least;
    }
}