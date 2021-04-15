package Codeforces;

import java.util.Random;
import java.util.Scanner;

/**
 * CodeForce_1511B
 */
public class CodeForce_1511B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if(a < b){
                int temp = a;
                a = b;
                b = temp;
            }
            // we have to output any solution where gcd(x,y) = z
            int num = getRandomNumberUsingInts(b); // second number
            int gcd = calculateMinGCD(num,c); // gcd of two numbers
            int num2 = calulateOtherNumber(gcd,a);
            
            System.out.println(num2 + " " + num + " GCD:" + gcd);
            System.out.println(num);

        }
        sc.close();
    }

   private static int calulateOtherNumber(int gcd, int a) {
        int ll =(int) Math.pow(10, a-1);
        int ul = ll*10;
        int num = gcd;
        while(true){
            if(ll <= num && ul > num){
                return num;
            }
            num = num*10;
        }
    }

 private static int calculateMinGCD(int num, int c) {
        
        int ll =(int) Math.pow(10, c-1);
        int ul = ll*10;
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0){
                int icom = num/i;
                if(i >= ll && i < ul){
                    return i; 
                } else if(icom >= ll && icom < ul){
                    return icom;
                }
            }
        }
        return num;
    }

    public static int getRandomNumberUsingInts(int num) {
        int min =(int) Math.pow(10, num-1);
        int max = min*10;

        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }
}