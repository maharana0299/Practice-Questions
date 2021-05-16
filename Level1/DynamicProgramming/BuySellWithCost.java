package DynamicProgramming;

import java.util.Scanner;

/**
 * BuySellWithCost
 */
public class BuySellWithCost {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        
        int tc = sc.nextInt();
        
        int profit = calculateProfitWithTransaction(arr,n,tc);
        System.out.println(profit);
        sc.close();
    }

    private static int calculateProfitWithTransaction(int[] arr, int n, int tc) {

        int obsp, ossp;
        obsp = -arr[0];
        ossp = 0;

        for (int i = 0; i < n; i++) {

            int nssp, nbsp;

            if (ossp - arr[i] > obsp) {
                nbsp = ossp - arr[i];
            } else {
                nbsp = obsp;
            }

            if (obsp + arr[i] - tc > ossp){
                nssp = obsp + arr[i] - tc;
            } else {
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }

}