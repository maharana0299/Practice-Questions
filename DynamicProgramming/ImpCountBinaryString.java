package DynamicProgramming;

import java.util.Scanner;

public class ImpCountBinaryString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        countBinaryNums(n);
        countBinaryDp(n);
        sc.close();
    }

    private static void countBinaryDp(int n) {
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = 0;
        dp1[1] = 1;
        for (int i = 1; i < n; i++) {
            dp0[i] = dp1[i-1];
            dp1[i] = dp0[i-1] + dp1[i-1];
        }
    }

    private static void countBinaryNums(int n) {
        // using dp

        int curr0 = 0, curr1 = 0;
        int next0 = 0, next1 = 1;
        for (int i = 0; i < n; i++) {
            
            curr0 = next0;
            curr1 = next1;
            next0 = next1;
            next1 = curr1 + curr0;
        }

        System.out.println(curr1);
    }
}