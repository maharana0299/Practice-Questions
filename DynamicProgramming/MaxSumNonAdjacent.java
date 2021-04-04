package DynamicProgramming;

import java.util.Scanner;

public class MaxSumNonAdjacent{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = calculateMaxSumNonAdj(nums);
        System.out.println(max);
    }

    private static int calculateMaxSumNonAdj(int[] nums) {
        
        // inclusion exclusion 
        int inc[] = new int[nums.length+1];
        int exclude[] = new int[nums.length+1];

        for(int i = 1; i <= nums.length; i++) {

            inc[i] = nums[i-1]  + exclude[i-1];
            exclude[i] =  Math.max(inc[i-1], exclude[i-1]);
        }
        return Math.max(inc[nums.length],exclude[nums.length]);
    }
}