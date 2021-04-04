package DynamicProgramming;

import java.util.Scanner;

public class ArrangeBuildings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long way = arrrangeBuildings(n);

        System.out.println(way);

        sc.close();;
    }

    private static long arrrangeBuildings(Long n) {
        
        long dp0[] = new long[(int) (n+1)];
        long dp1[] = new long[(int) (n+1)];

        dp0[0] = 0;
        dp1[0] = 1;

        for( int i = 1; i <= n; i++) {
            dp0[i] = dp1[i-1];
            dp1[i-1] = dp1[i-1] + dp0[i-1] ;
       }
        long waysForOne = dp0[(int) (n+1)] * dp0[(int) (n+1)];
        return waysForOne * waysForOne;
    }
}