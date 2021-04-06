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
        
        
        return 0;
    }
}