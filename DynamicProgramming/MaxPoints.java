/**
 * MaxPoints
 */
public class MaxPoints {

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
        
            if(cardPoints.length < k)
                return 0;
            int dp[] = new int[k+1];
            
            // take i card from left
            // if we take 0 cards fro left the dp[0] = sum of arr[n-1] to arr[n-k];
            int n = cardPoints.length;
            for (int i = n-1; i >= n-k; i--) {
                dp[0] += cardPoints[i];
            }
            
            int max_points = dp[0]; //intitaly;
            
            for(int i = 1; i <= k; i++) {
                dp[i] = cardPoints[i-1] + dp[i-1] - cardPoints[n-k+i-1];
                
                if(dp[i] > max_points)
                    max_points = dp[i];
            }
            
            return max_points;
    //         int fi = 0;
    //         int li = cardPoints.length-1;
            
    //         int[][] dp = new int[li+1][li+1];
            
    //         return helper(cardPoints,k,fi,li,dp);
        }
        
        // this is our recursive approach and memoization
        public int helper(int[] arr, int k, int fi, int li, int[][] qb){
            
            if(k == 0)
                return 0;
            
            if(qb[fi][li] != 0)
                return qb[fi][li];
            
            int a = arr[fi] + helper(arr,k-1,fi+1,li,qb);
            int b = arr[li] + helper(arr,k-1,fi,li-1,qb);
            
            return qb[fi][li] =  Math.max(a,b);
        }
    }
}