

import java.util.Scanner;

/**
 * GcdSum
 */
public class CodeForce_1498A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        while(t-- >0){
            long smallestNum = sc.nextLong();
            while(true){
                if(gcdSum(smallestNum)> 1 ){
                    break;
                }
                smallestNum++;
            }
            System.out.println(smallestNum);
        }
        sc.close();
    }

    private static long gcdSum(long num) {

        long sumOfDigits = sumOfDigits(num);

        long gcd = gcd(num,sumOfDigits);
        return gcd;
    }

    private static long gcd(long num, long sumOfDigits) {

        long divisor = sumOfDigits;
        long dividend = num; 

        while (dividend % divisor != 0){
            long rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        return divisor;
    }

    private static long sumOfDigits(long num) {

        long sum = 0;

        while(num != 0){
            sum += num % 10;
            num = num/10;
        }
        return sum;
    }
}