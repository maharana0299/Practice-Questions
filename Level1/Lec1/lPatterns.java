package Lec1;

import java.util.Scanner;

class lPatterns {
    static Scanner sc = new Scanner(System.in);

    public static int n;

    public static void main(String[] args) {
        n = sc.nextInt();
        sc.close();
    }
    
    public static void pattern3(int n) {
     
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j < i; j ++) {
                System.out.print("\t");
            }
            for(int j = i; j < n; j++) {
                 System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern1(int n){

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            for(int j = i; j < n; j ++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n){
        int controller = 0;
        double upper = Math.ceil(n/2.0);
        for(int i = 1; i <= n; i++) {
            
            if( i <= upper) {
                ++controller;
            } else if ( i > upper) {
                controller--;
            }
            
            for (int gap = 0; gap < upper - controller; gap++) {
                    System.out.print("\t");
            }
            for(int j = 0; j < 2*controller - 1; j++) {
                    System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n){
        double upper = Math.ceil(n/2);
        double cnt = upper + 1;
       
        for(int i = n; i > 0; i--) {
            
            if (i > upper)
            cnt--;
            else cnt++;
            for(int j = 0; j <= cnt; j ++) {
                System.out.print("*\t");
            }
            
            for (double j = cnt+1; j <= upper; j++) {
                System.out.print("\t");
            }
            System.out.print("\t");
            for (double j = cnt+1; j <=upper; j++) {
                System.out.print("\t");
            }
            for(int j = 0; j <= cnt; j ++) {
                System.out.print("*	");
            }
            System.out.println();
        }

    }

    public static void pattern7(int n){
        for(int i = 0; i < n; i++){
            for(int j= 0; j < i; j++) { 
                System.out.print("\t");
            }
            System.out.print("*\n");
        }
    }

    public static void pattern8(int n){
        for(int i = 0; i <n; i++){
            for(int j = 0; j < n-i- 1; j++) {
                System.out.print("\t");
            }
            System.out.print("*\n");
        }
    }

    public static void pattern9(int n){
        for(int i = 0; i <n; i++){
            for (int j = 0; j < n; j++) {
               if ( ((n-i-1) == j) || i == j ) System.out.print("*\t");
               else System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public static void pattern10(int n){
        /**
     *  innerspace and outerspace
     *  2               -1
     *  1                1
     *  0                3
     *  1                1
     *  2               -1
     * */
    
        int os = n/2 ;
        int is = -1;

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= os; j++) {
                System.out.print("\t");
            }
            System.out.print("*");
            for(int j =0; j <= is; j++) {
                System.out.print("\t");
            }

            if (i > 1 && i < n) {
                System.out.print("*");
            }
            if (i <= n /2) {
                os--;
                is += 2;
            } else  {
                os++;
                is -= 2;
            }
            
            System.out.println();
        }
    }

    public static void pattern11(int n){
        int num = 1; 
        for(int i = 0; i <n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num++ + "\t" );
            }
            System.out.println();
        }
    }

    public static void pattern12(int n){
        int first = 0;
        int last = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(first + "\t");
             
                int temp = last;
                last = last + first;
                first = temp;
            }
            System.out.println();
        }
    }

    public static void pattern13(int n){

        for (int i =  0; i < n; i++){

            int icj = 1;
            for (int j =0; j <= i; j++){
                System.out.print(icj + "\t");
                int icjp1 = (icj * (i-j) ) / (j+1);

                icj = icjp1;
            }
            System.out.println();
        }
    }

    public static void pattern14(int n) {
        /**
         * n * 1 = n
         * n * 2 = 2n
         */

         for (int i = 1; i <= 10; i++){
             System.out.println (n + " * " + i + " = " + (n*i));

         }
    }

    public static void pattern15(int n){
        
        
        int ch = 1;
        int digit = 1;
        int mid = (n+1)/2;
        int is = mid -1;
        
        for (int i = 1; i <=n; i++){
            for(int j = 0; j < is; j++){
                System.out.print("\t");
            }
            
            int dig = digit;
            int m = (ch+1)/2;
            for (int j = 1; j <= ch; j++) {
                if (j < m) System.out.print(dig++ + "\t");
                else if (j == m) System.out.print(dig-- + "\t");
                else System.out.print(dig-- + "\t");
            }
            
            if (i < mid){
                is--;
                ch += 2;
            }   
            else {
                is++;
                ch -= 2;
            }
            
            if (i < mid) digit++;
            else digit--;
            
            System.out.println();
        
        }
    }

    public static void pattern16(int n){
        int is = n*2 - 1 ;
        //int mid = (n+1)/2;
        
        for(int i =1; i<= n; i++){
            is = is-2;
            
            if (is < 0) is = 0;
            int dig = 0;
            for (int j = 1; j <= i; j++) {
                System.out.print(++dig + "\t");
            }
            
            for (int j =1; j <= is; j++) {
                System.out.print("\t");
            }
            
            for (int j= 1; j <= i; j++) {
                
                if (dig == n) {
                    dig--;
                    continue;
                }
                System.out.print(dig-- + "\t");
            }
            
            System.out.println();
        }
    }

    public static void pattern17(int n){
        int tail = n/2;
        
        int ch = 1;
        for (int i = 1; i <= n; i++){

            for (int j = 1; j <= tail; j++){
                if (i == (tail+1) ) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            

            for(int j = 0; j < ch; j++){
                System.out.print("*\t");
            }
            
            if (i < (tail+1) )  ch++;
            else ch--;
            System.out.println();
            
        }
    }

    public static void pattern18(int n) {
        int mid = (n+1)/2;
        int os = 1;
        int is = n - 4;

        for(int i = 1; i <= n; i++){
            System.out.print("*\t");
        }
        System.out.println();
        
        for(int i = 1; i < mid; i++){
            for (int j = 0; j < os; j++){
                System.out.print("\t");
            }

            System.out.print("*\t");

            for(int j = 0; j <is; j++){
                System.out.print("\t");
            }
            if (is > 0) System.out.print("*\t");

            os++;
            is = is - 2;
            
            System.out.println();
        }
        os--;
        int ch =1;
        for(int i = 0; i <  mid-1; i++) {
            
            ch = ch + 2;
            os--;
            
            for(int j = 0; j < os; j++){
                System.out.print("\t");
            }
            for(int j = 0; j < ch; j++) {
                System.out.print("*\t");
            }
            
            System.out.println();
        }
    }

    public static void pattern19(int n){
        for(int i =1; i<= n; i++){
            for (int j =1; j <= n; j++){
                
                if (i ==1) {
                    if ( j == n || j <= n/2 + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if ( i <= n/2) {
                    if (j == n || j == n/2 + 1) {
                     System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (i == n/2 + 1) {
                    System.out.print("*\t");
                } else if (i < n) {
                    if (j == 1 || j == n/2 + 1) {
                     System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if (j == 1 || j >= n/2+1){
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
         
    }

    public static void pattern20(int n){
        
        for(int i =1; i <= n; i++){
            for (int j = 1; j<= n; j++){
                
                if (j == 1 || j == n){
                    System.out.print("*\t");
                } else if ( (i > n/2) && ((i == j) || (i +j == n + 1))) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

}