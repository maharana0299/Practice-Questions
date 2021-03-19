import java.util.*;

public class l002{

    public static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        lineWiseDigits(n);
    }

    
    
    public static int countDigit(int n){
        int count = 0;
        int num = n;

        while(num != 0) {
            num /= 10;
            count++;           
        } 

        return count;
    }

    public static void lineWiseDigits(int n) {
        int num = n;
        int len = countDigit(num);

        int div = 1;
        while(len-- > 1) {
            div *= 10;
        }

        while(div != 0 ){
            System.out.println(n/div);
            n = n % div;
            div /= 10;
        }
    }
}