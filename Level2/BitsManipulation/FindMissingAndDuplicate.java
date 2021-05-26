import java.util.Scanner;

public class FindMissingAndDuplicate {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
    }

    public static void solution(int[] arr) {

        int xor = 0;

        for (int i : arr) {
            xor ^= i;
        }

        // create duplicacy

        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }

        int rmsb = xor & -xor;

        // looping again to get those two numbers
        int x = 0, y = 0;

        for (int i : arr) {

            if ((i & rmsb) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (int i = 1; i <= arr.length; i++) {

            if ((i & rmsb) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // check for missing
        for (int i : arr) {

            // if found that dupl
            if (x == i) {
                System.out.println("Missing Number -> " + y);
                System.out.println("Repeating Number -> " + x);
                break;
            } else if (y == i) {
                System.out.println("Missing Number -> " + x);
                System.out.println("Repeating Number -> " + y);
                break;
            }
        }

    }
}
