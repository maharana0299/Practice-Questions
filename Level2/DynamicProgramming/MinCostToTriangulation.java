
/**
 * We are using Gap strategy 2 Gap startegy 1 uses dp[i][j] = dp[i][j-1] || dp[i+1][j]
 * While Gap starategy 2 uses different approach 
 */
public class MinCostToTriangulation {
    public static int minScoreTriangulation(int[] arr) {
        
        int n = arr.length;

        // stores min cost of triangualtion of polygon from i to g
        int[][] dp = new int[n][n];

        // using gap startegy
        for(int gap = 0; gap < n; gap++){

            // traverse 
            for(int i = 0, j = gap; j < n; j++,i++) {

                // bases cases
                if(gap == 0) {
                    // for 1 vertices
                    dp[i][j] = 0;
                } else if(gap == 1){
                    // for 2 vertices
                    dp[i][j] = 0;
                } else if(gap == 2){
                    // for 3 vertices
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
                } else {

                    int cost = Integer.MAX_VALUE;
                    // travel for every possible way 
                    // i...k + k...j
                    for(int k = i+1; k < j; k++) {
                        int costHere = arr[i]*arr[j]*arr[k]
                            + dp[i][k] // i to k
                            + dp[k][j]; // k to j 
                        if(cost > costHere){
                            cost = costHere;
                        }
                    }

                    dp[i][j] = cost;
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
    }
}
