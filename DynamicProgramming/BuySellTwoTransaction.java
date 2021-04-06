package DynamicProgramming;

import java.util.Scanner;

/**
 * BuySellTwoTransaction
 * Most Important Question *****************
 */
public class BuySellTwoTransaction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = buySellTwoStock(arr);
        System.out.println(max);
    }

    private static int buySellTwoStock(int[] arr) {
        
        int leastSoFar = arr[0];
        int mpist = 0; // max profit if sell today
        int n = arr.length;
        int maxProfitIfSellOnOrBeforeToday[] = new int[n];
        int maxProgitIfBoughOnOrAfterToday[] = new int[n];

        for (int i = 1; i < maxProfitIfSellOnOrBeforeToday.length; i++) {
            

            if (leastSoFar > arr[i] )
                leastSoFar = arr[i];

            mpist = arr[i] - leastSoFar;

            if(maxProfitIfSellOnOrBeforeToday[i-1] < mpist){
                maxProfitIfSellOnOrBeforeToday[i] = mpist;
            } else {
                maxProfitIfSellOnOrBeforeToday[i] = maxProfitIfSellOnOrBeforeToday[i-1];
            }
        }

        int mpibt = 0; // max profit if bought toady 
        int maxSoFar = arr[n-1];

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > maxSoFar){
                maxSoFar = arr[i];
            }
            mpibt = maxSoFar - arr[i];
            if (maxProgitIfBoughOnOrAfterToday[i-1] < mpibt){
                maxProgitIfBoughOnOrAfterToday[i]  = mpibt;
            } else {
                maxProgitIfBoughOnOrAfterToday[i] = maxProgitIfBoughOnOrAfterToday[i-1];
            }
        }

        int overallProfit = 0;

        for(int i = 0; i < n; i++) {
            if (overallProfit < maxProfitIfSellOnOrBeforeToday[i] + maxProgitIfBoughOnOrAfterToday[i]){
                overallProfit = maxProfitIfSellOnOrBeforeToday[i] + maxProgitIfBoughOnOrAfterToday[i];
            }
        }
        return overallProfit;
    }
}