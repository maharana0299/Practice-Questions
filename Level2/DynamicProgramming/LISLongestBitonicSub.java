import java.util.*;

// a bitonic is a subsequence which first increase then decreases
// eg:  3 5 6 7 7 8 3 2 1 -> this is a bitonic 
public class LISLongestBitonicSub {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // find lowest increasing subsequence till i including i
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {

            int max = 0;

            for (int j = 0; j < i; j++) {
                // if less then it can definetly form a subsequence with our i
                // so if max is less than dp[j], ie. lcs including j till j
                if (arr[j] <= arr[i]) {
                    if (lis[j] > max) {
                        max = lis[j]; // longest subsquence till j
                    }
                }
            }

            // after this including i also
            lis[i] = max + 1; // longest subsequence till j and then including i also
        }

        // then find longest decreasing subsequence tii i including i
        int[] lds = new int[n];

        // travelling backward and finding lds
        for (int i = n - 1; i >= 0; i--) {

            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] <= arr[i]) { // if j i is larger than j then it can be a longest decreasing subsequence
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }

            lds[i] = max + 1;
        }

        // now we have lis and lbs eg 1 2 3 and 3 2 are lis ans lbs at ith index
        // then bitionic will be lis[i] + lbs[i] - 1; // as ith index is included twice
        // hence removing it
        int omax = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }
        System.out.println(omax);
    }

}