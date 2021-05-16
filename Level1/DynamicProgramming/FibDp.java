package DynamicProgramming;

import java.util.Scanner;

public class FibDp{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] qb = new int[n+1];
    
    int f = fib(n,qb);
    
    System.out.println(f);
    sc.close();
 }
 
 public static int fib(int n, int[] qb) {
     
     if (n == 0 || n == 1) {
         return n;
     }
     
     if (qb[n] != 0)
        return qb[n];
    
    return fib(n-1,qb) + fib(n-2,qb);
 }
}