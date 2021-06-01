package CH2;

import java.util.Scanner;

public class tomAndJerry {
    
    static int lim = 100000;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n-- >0) {

            int a,b,c,d,k;

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            k = sc.nextInt();

            // mem = new Boolean[lim][lim][k];

            int minD = (int) Math.pow(Math.pow(a-c, 2) + Math.pow(b-d, 2),0.5);

            boolean canReach = minD <= k && canTomreach(a,b,c,d,k);

            if(canReach){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // static Boolean[][][] mem;
    private static boolean canTomreach(int a, int b, int c, int d, int k) {
        

        if(a == c && b == d && k == 0)
            return true;
        if(k <= 0 )
            return false;;

        // if(mem[a][b][k] != null)
        //     return mem[a][b][k];

        boolean reach = false;
        if(a+1 < lim)
        reach = reach || canTomreach(a+1, b, c, d, k-1);
        if(a-1>=0)
        reach = reach || canTomreach(a-1, b, c, d, k-1);
        if(b+1<lim)
        reach = reach || canTomreach(a, b+1, c, d, k-1);
        if(b-1>=0)
        reach = reach || canTomreach(a, b-1, c, d, k-1);
        
        return reach;
    }
}
