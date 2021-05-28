import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinXorPair {

    public static void solution(int[] arr) {

        // sort the array first
        Arrays.sort(arr);

        // make a list to store min pairs
        // as more than one pair can be possible
        List<String> ls = new ArrayList<>();

        // initially min is MAX_VALUE
        int min = Integer.MAX_VALUE;

        // length of the array is stored in n
        int n = arr.length;

        // for n-1 numbers, we can selet pair as its next element
        // we dont need to check every other possible pairs
        // this is coz, if a<b<c, then it can be two cases
        // either a^b < a^c or b^c < a^c
        // in both cases we dont need to expore a^c as it will never be minimun
        for (int i = 0; i < n - 1; i++) {

            int xor = arr[i] ^ arr[i + 1];

            if (xor < min) {

                // if new min is found the clear the old array list ans
                // add the pair to new list
                ls = new ArrayList<>();
                ls.add(arr[i] + ", " + arr[i + 1]);
                min = xor;
            } else if (xor == min) {
                ls.add(arr[i] + ", " + arr[i + 1]);
            }
        }

        for (String i : ls) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
