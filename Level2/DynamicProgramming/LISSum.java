import java.util.Scanner;

/**
 * LongestIncreasingSubSequenceSum
 */
public class LISSum {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int maxSum = findMSIS(arr);
        System.out.println(maxSum);
        sc.close();
    }

    public static int findMSIS(int arr[]) {

        int omax = 0;
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {

                // if both are equal or less then it can be included 
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j]; // longest Sum subsquence till j
                    }
                }
            }

            // after this including i also
            if (max != Integer.MIN_VALUE)
                dp[i] = max + arr[i]; // longest Sum subsequence till j and then including i also
            else
                dp[i] = arr[i];

            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        return omax;
    }
}