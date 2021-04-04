package DynamicProgramming;

import java.util.Scanner;

public class CountABSSub{

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        int count = countSubsequence(str);
        System.out.println(count);

        sc.close();
    }
    
    public static int countSubsequence(String s) {
        
        int n = s.length();
        int[] a = new int[n+1];
        int[] ab = new int[n+1];
        int[] abc = new int[n+1];
        
        a[0] = 0;
        ab[0] = 0;
        abc[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            
            char ch = s.charAt(i-1);
            
            a[i] = a[i-1];
            ab[i] = ab[i-1];
            abc[i] = abc[i-1];
            
            if (ch == 'a') {
                a[i] = 2*a[i-1] + 1;
            } else if (ch == 'b') {
                ab[i] = 2 * ab[i-1] + a[i-1];
            } else if (ch == 'c') {
                abc[i] = 2 * abc[i-1] + ab[i-1];
            }
        }
        
        return abc[n];
    }
}