import java.util.Scanner;

public class Solve7nBy8 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // 7n/8 = (8n - n)/8

        // mtl
        int sol = (n << 3);
        // sub
        sol -= n;

        // divide
        sol = (sol >>> 3);

        System.out.println(sol);
    }
}
