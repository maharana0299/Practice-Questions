
/**
 * R080521
 */
public class R080521 {
    
    public int fibonacii(int n) {

        int fib[] = new int[n+1];
        
        /**
         * Meaning -> each element stores the factorial 
         */

         fib[0] = 1;
         fib[1] = 1;

         for(int i = 2; i <= n; i++) {
             fib[i] = fib[i-1] + fib[i-2];
         }

         return fib[n];
    }

    public static int climbVariable(int n,int path[]) {
        
        int[] dp = new int[n+1];
        
        dp[n] = 1; // from ith to n how many paths ? 

        // downward approach is more convinient use 
        // coz from that position we can jump x stairs, ie. moving up.
        
        for (int i = n-1; i >= 0; i--) {
            
            for (int j = 1; j <= path[i] && j + i <= n; j++){
                dp[i] += dp[i+j];
            }
        }
        
        return dp[0];
    }

    public static Integer findMinMoves(int[] moves, int n) {

        Integer minMoves[] = new Integer[n+1];
        
        minMoves[n] = 0; // Minimum moves to go from last position to loas position is zero
        
        for(int i = n-1; i >= 0; i--) {

            if(moves[i] > 0) {
                
                int min = Integer.MAX_VALUE;

                for(int j = 1; j <= moves[i] && i + j <= n; j++) {

                    if(minMoves[i+j] != null)
                    min = Math.min(min, minMoves[i+j]);
                }
                
                if(min != Integer.MAX_VALUE)
                minMoves[i] = 1 + min;
            }
        }

        return minMoves[0];
    }

    public static int getLeastCost(int[][] cost) {
        
        int n = cost.length;
        int m = cost[0].length;
        
        int dp[][] = new int[n][m];

        /**
         * Each element stores the min cost to travel from ij th element to last element 
         */
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                
                if (i == n-1 && j == m-1) {
                    dp[i][j] = cost[i][j];
                } else if (i == n-1) {
                    dp[i][j] = cost[i][j] + dp[i][j+1];
                } else if (j == m-1) {
                    dp[i][j] = cost[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = cost[i][j] + Math.min(
                        dp[i+1][j],dp[i][j+1]
                        );
                }
            }
        }
        
        return dp[0][0];
    }

    public static int calculateGoldMine(int mines[]) {
        
        return 0;
    }

}