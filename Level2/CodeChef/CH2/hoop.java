package CH2;

import java.util.Scanner;

/**
 * hoop
 */
public class hoop {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-->0) {

            int n = sc.nextInt();

            int lastPos = findLastPos(n);
            System.out.println(lastPos);
        }
    }

    private static int findLastPos(int n) {

        return n/2 + 1;
    }
}