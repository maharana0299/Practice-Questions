package Lec2;

public class l20201212 {

    public static void main(String... args){

    }

    public static void reveseNumber(int n){
        // we have to print reverse of a number

        while( n > 0) {
            int dig = n %10;
            n /= 10;
            System.out.print(dig);
        }
    }

    public static void inverseANumber(int n){
        int inverse = 0;
        int originalPosition = 1;

        while( n != 0){
            int originalDigit = n % 10;
            int invertedNumber = originalPosition;
            int invertedPlace =  originalDigit;

            //make changes to inverse
            inverse = inverse + (int) Math.pow(10,invertedPlace - 1) * invertedNumber;

            n /= 10;
            originalPosition++;
        }

    }

    public static void rotateNumber(int n, int k) {

        int numberOfDigits = calculateDigits( n);
        k = k % numberOfDigits;  // taking mod to get minumum number of k

        if (k < 0)
            k = k + numberOfDigits;; // converting negative rotation to psoitive rotation 
        
        int div = 1;
        int mlt = 1;

        for (int i =1; i<= numberOfDigits; i++ ){
            if (i <= k)
                div *= 10;
            else  
                mlt *= 10;
            
        }

        int q = n / div;
        int r = n % div;

        int rotated = r*mlt + q;

        System.out.print(rotated);
    }

    private static int calculateDigits(int n) {
        int digits = 0;
        while(n  > 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }

    public static void benjaminBulbs(int n){
        // we have to print perfect squares;

        for (int i = 1; i * i <= n; i++){
            System.out.println(i * i);
        }
    }

    public static void exitPoint(int[][] arr) {
		// Write your code only here.
        int dir  = 0;
        int i = 0;
        int j = 0;
         
        while (true) {
            dir = (dir + arr[i][j]) %4;
            
            if (dir == 0) {
                // east
                j++;
            } else if (dir == 1){
                //south
                i++;
            } else if (dir == 2) {
                j--;
            } else if (dir == 3) {
                i--;
            }
            
            if ( i< 0) {
                i++ ;
                break;
            } else if (j < 0){
                j++;
                break;
            } else if (i == arr.length){
                i--;
                break;
            } else if (j == arr.length){
                j--;
                break;
            }
        }
        
        System.out.println(i + "\n" + j);
        
	}
}