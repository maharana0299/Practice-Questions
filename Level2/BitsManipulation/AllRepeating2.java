import java.util.Scanner;

public class AllRepeating2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {

        // take xor
        int x = 0;

        for (int i : arr) {
            x ^= i;
        }

        // rmsb
        int rmsb = x & -x;

        int a = 0;
        int b = 0;

        // dividing in two sets
        for (int i : arr) {

            if ((i & rmsb) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }

        if (a > b) {
            System.out.println(b);
            System.out.println(a);
        } else {
            System.out.println(a);
            System.out.println(b);
        }

    }
}
