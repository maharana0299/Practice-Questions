package DynamicProgramming;

/**
 * GamStrategy
 */
public class GamStrategy {

    static long countMaximum(int arr[], int n){
        Long dp[][] = new Long[n][n];        
        long x,y,z;
        int gap;
        int i,j;
        
        for(gap = 0; gap < n; gap++) {
            
            for(i = 0, j = gap; j < n; j++,i++) {
                
                x = (i+2) <= j ? dp[i+2][j] : 0;
                
                y = (i+1) <= (j-1) ? dp[i+1][j-1] : 0;
                
                z = (i) <= (j-2) ? dp[i][j-2] : 0;
                
                dp[i][j] = Math.max(
                    arr[i] + Math.min(x,y),
                    arr[j] + Math.min(y,z)
                    );
            }
        }
        
        return dp[0][n-1];
    }
    
    /**
     * Memoized version
     * @param arr - array of values
     * @param s - starting point
     * @param end - end point 
     * @param q - To Strore the previous values
     * @return return maximum amount that can pe picked
     * 
     * maximum(arr,0,n-1,dp); 
     */
    static long maximum(int[] arr, int s, int end, Long[][] q) {
        
        if (s > arr.length-1 || end < 0 || s > end){
            return 0;
        }
        
        if (q[s][end] != null ) {
            return q[s][end];
        }
        
        long selectsFirst = arr[s] + Math.min( maximum(arr,s+2,end,q), maximum(arr,s+1,end-1,q));
        
        long selectsEnd = arr[end] + Math.min( maximum(arr,s,end-2,q), maximum(arr,s+1,end-1,q) );
        
        return q[s][end] =  Math.max(selectsFirst, selectsEnd);
    }
}