package Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * R080521
 */
public class R080521 {
    
    public static int fibonacii(int n) {

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

    public static int calculateGoldMine(int mines[][]) {
        
        int n = mines.length;
        int m = mines[0].length;

        int profit[][] = new int[n][m];
        int maximum = Integer.MIN_VALUE;

        for(int j = m-1; j >= 0; j--) {
            for(int i = 0; i < n; i++) {

                if(j == m-1) {
                    
                    profit[i][j] = mines[i][j];
                } else if(i == n-1) {
                    
                    profit[i][j] = mines[i][j] + Math.max(profit[i][j+1], profit[i-1][j+1]);
                } else if(i == 0) {
                    
                    profit[i][j] = mines[i][j] + Math.max(profit[i][j+1], profit[i+1][j+1]);
                    
                } else {

                    int c1 = profit[i][j+1];
                    int c2 = profit[i+1][j+1];
                    int c3 = profit[i-1][j+1];

                    profit[i][j] = mines[i][j] + Math.max(c1, Math.max(c2, c3));
                }
            }
        }

        for(int i = 0; i < n; i++) {

            if(maximum < profit[i][0])
                maximum = profit[i][0];
        }
        return maximum;
    }

    public static boolean findTargetSum(int [] c, int t) {
        
        int n = c.length;
        boolean[][] isTarget = new boolean[n+1][t+1];

        /**
         * Is taget present for an t[i,j] = isTarget there is prev ie, t[i-1][j] or target present in t[i-1][j-c[i-1]]
         * if zero elements are selected then no target
         * if trget is zero then true for all
         */

        for(int i = 0; i <= n; i++) {
            isTarget[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= t; j++) {

                isTarget[i][j] = isTarget[i-1][j];

                if(c[i-1] <= j) {

                    isTarget[i][j] |= isTarget[i-1][j-c[i-1] ]; 
                }
            }
        }
 
        return isTarget[n][t];
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        
        // s1 = (S + sumArray)
        int sum = 0;
        for(int i: nums) 
            sum += i;;
        if (nums.length == 0  || (S + sum) % 2 != 0)  return 0;
        
        int target =((S + sum ) /2 );
        if (target > sum) return 0;
        int[][] t = new int[nums.length + 1][target+1];
        
        
        for (int i = 0; i <= target; i++) {
            t[0][i] = 0;
        }
        
        t[0][0] = 1;
        for (int i = 1; i <= nums.length; i++)
        for (int j = 0; j <= target; j++){
                if( nums[i-1] <= j ) {
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
                } else t[i][j] = t[i-1][j];
            }
        return t[nums.length][target];
    }

    public List<String> addOperators(String num, int target) {
        
        // made an arraylist 
        List<String> rst = new ArrayList<String>();
        
        helper(rst,num,target,0,0,0,""); 
        return rst;
    }
    
    public void helper(List<String> rst, String num, int target, int pos, long eval, long mlt, String path) {

        if(pos == num.length()) {
            if(target == eval) {
                rst.add(path);
            }

            return;
        }
        
        for(int i = pos; i < num.length(); i++) {    

            if(i != pos && num.charAt(pos) == '0')
                break;

            long curr = Integer.parseInt(num.substring(pos, i+1));
            if(i == 0) {

                helper(rst, num, target, pos + 1, curr, curr, path + curr);
            } else {

                helper(rst, num, target, pos+1, eval + curr, curr, path + "+");
                helper(rst, num, target, pos+1, eval - curr, curr, path + "-");
                helper(rst, num, target, pos+1, eval - mlt + mlt * curr, mlt * curr, path + "*" + curr);
            }
        }
    }
}

