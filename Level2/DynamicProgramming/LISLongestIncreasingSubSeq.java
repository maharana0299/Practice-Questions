import java.util.*;

public class LISLongestIncreasingSubSeq {

    public static void main(String[] args) throws Exception {
        
        // taking input 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        
        int liss = liss(arr, n);
        System.out.println(liss); 
    }

    // longest increasing subsequence
    public static int liss(int[] arr, int n) {

        // overall max
        int omax = 0;
        // longest increasing subsequence till ith element including the ith element
        // to calculate the longest subsequqnce we have to look for every possible value of i
        // and store the longest subsequence including ith element 
        // in the end we will return the biggest subsequence 
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) {
            
            int max = 0;
            
            for(int j = 0; j < i; j++) {
                // if less then it can definetly form a subsequence with our i 
                // so if max is less than dp[j], ie. lcs including j till j
                if(arr[j] <= arr[i]) {
                    if(dp[j] > max) {
                        max = dp[j]; // longest subsquence till j 
                    }
                }
            }
            
            // after this including i also 
            dp[i] = max + 1; // longest subsequence till j and then including i also
            
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        
        // System.out.println(omax);
        return omax;
    }

}