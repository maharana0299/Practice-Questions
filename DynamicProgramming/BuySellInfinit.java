package DynamicProgramming;

import java.util.Scanner;

/**
 * BuySellInfinit
 */
public class BuySellInfinit {

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
        
        int by = 0;
        int sell = 0;
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            
            if (arr[i] > arr[i-1]) {
                sell++;
            } else{

                profit += arr[sell] - arr[by];
                by = i;
                sell = i;
            }
        }

        profit += arr[sell] - arr[by];

        return profit;
    }
}