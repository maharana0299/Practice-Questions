package Codechef;

import java.util.Scanner;

/**
 * BUYPLEASE
 */
public class BUYPLEASE {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int tc = a * x + b * y;
        System.out.println(tc);

        sc.close();
    }
}