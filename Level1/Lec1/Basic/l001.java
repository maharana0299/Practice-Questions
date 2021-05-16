package Lec1.Basic;

public class l001 {
    public static void printZ() {
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }
    public static void main(String[] args) {
        printZ();
    }

    public static void gradientSystem(int n){
        if (n > 90) {
            System.out.println("excellent");
        } else if (n > 80 && n <=90) {
            System.out.println("good");
        } else if (n > 70 && n <= 80) {
            System.out.println("fair");
        } else if (n > 60 && n <= 70) {
            System.out.println("meets");
        } else if (n <= 60) {
            System.out.println("below par");
        }
    }

    public static boolean isPrime_(int n) {
       for (int i = 2; i*i <= n; i++)  {
           if (n % i == 0) {
               return false;
           }
       } 
       return true;
    }

    public static void isPrime(){
    }

}