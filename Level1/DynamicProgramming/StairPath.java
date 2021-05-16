package DynamicProgramming;
import java.util.Scanner;

public class StairPath{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int p = climbStairs(n, new int[n+1]);
        System.out.println(p);
        sc.close();
    }
    
    public static int climbStairs(int n, int[] qb){
        
        if(n == 0) 
            return 1;
        if(n < 0) {
            return 0;
        }
        
        if (qb[n] > 0)
            return qb[n];
            
        int p1 = climbStairs(n-1,qb);
        int p2 = climbStairs(n-2,qb);
        int p3 = climbStairs(n-3,qb);
        
        return p1+p2+p3;
    }

    // using tabulation 
    public static int calculateStairsPathByTab(int n){
        int qb[] =  new int[n+1];
        qb[0] = 1;

        for (int i = 1; i <= n; i++){
            if (i == 1) {
                qb[i] = qb[i-1];
            } else if (i == 2) {
                qb[i] = qb[i-1] + qb[i-2];
            } else {
                qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
            }
        }

        return qb[n];
    }
}