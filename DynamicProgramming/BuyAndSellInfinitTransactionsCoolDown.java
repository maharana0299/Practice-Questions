package DynamicProgramming;

/**
 * BuyAndSellInfinitTransactionsCoolDown
 */
public class BuyAndSellInfinitTransactionsCoolDown {

    import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int pro = findBuySell(arr,n);
        System.out.println(pro);
    }
    
    public static int findBuySell(int[] arr, int n){
        int obsp = -arr[0], ossp =  0, ocsp = 0;
        
        for(int i = 1; i < n; i++) {
            int nbsp = 0, nssp = 0, ncsp = 0;
            
            if (ocsp - arr[i] > obsp) {
                nbsp = ocsp - arr[i];
            } else {
                nbsp = obsp;
            }
            
            if (obsp + arr[i] > ossp) {
                nssp = obsp + arr[i];
            } else 
                nssp = obsp;
            
            if (ossp > ocsp) {
                ncsp = ossp;
            } else ncsp = ocsp;
            
            ocsp = ncsp;
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }

}
}