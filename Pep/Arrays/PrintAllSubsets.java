package Pep.Arrays;

import java.util.Scanner;

/**
 * PrintAllSubsets
 */
public class PrintAllSubsets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printAllSubsets(arr,0,"");
        sc.close();
    }

    private static void printAllSubsets(int[] arr, int i, String string) {

        if(i == arr.length){
            System.out.println(string);
            return;
        }

        printAllSubsets(arr,i+1,string + "\t" + "-");
        printAllSubsets(arr, i+1, string + "\t" + arr[i]);

    }
}