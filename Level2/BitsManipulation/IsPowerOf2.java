import java.util.Scanner;

public class IsPowerOf2 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int count = 0;
        
        while(n > 0) {
            
            n = n - (n & -n);
            count++;
            
            if(count>1)
                break;
        }
        
        if(count != 1) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }

        // m2 

        boolean isPowerOf2 = false;

        if((n & (n-1)) == 0)
            isPowerOf2 = true;
        
      }
}
