import java.util.Scanner;

public class MinSwapOfBit {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        int xor = a ^ b;

        int count = 0;

        while (xor > 0) {

            int rmsb = xor & -xor;

            count++;
            xor = xor - rmsb;
        }

        System.out.println(count);
    }
}
