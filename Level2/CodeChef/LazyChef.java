import java.util.Scanner;

public class LazyChef {
    
    /**
     * First line will contain T, number of testcases. Then the testcases follow.
     * Each testcase contains a single line of input, three integers x,m,d
     *  can delay by at max d : total max time can be x + d
     *  
     * 3
     * x m d
     * 1 1 0    -> 1
     * 1 3 1    -> 2 
     * 2 2 3    -> 4
     */

     public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {

            int x = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            int ub = x + d;
            int ttwm = x*m;

            System.out.println(Math.min(ub,ttwm));
        }

        sc.close();
     }
}
