package SortingAndTimeComplexity;

import java.util.*;

public class SortInLinearTime {

    public static void sort01(int[] arr) {
        /**
         * dividing in two parts 000011110100110101 0 to i-1 -> 0's i to j -> 1's j to
         * n-1 -> unknown
         */
        int i = 0; // initially
        int j = 0;

        while (j < arr.length) {

            if (arr[j] == 1) {
                j++;
            } else {
                swap(arr, j, i);
                i++;
                j++;
            }
        }

    }

    public static void sort012(int[] arr){
    
        int i = 0;
        int j = 0;
        int k = arr.length;
        
        while(j < k) {
            
            if (arr[j] == 1) {
                j++;
            } else if(arr[j] == 0) {
                swap(arr, j, i);
                i++;
                j++;
            } else {
                swap(arr,j,k-1);
                k--;
            }
        }
        
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort01(arr);
        print(arr);
        scn.close();
    }

}
