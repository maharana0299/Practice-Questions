package DynamicProgramming;

/**
 * MinPartition
 */
public class MinPartition {

    public int minDiffernce(int a[], int n) 
	{ 
	    // calculate total sum 
	    
	    int sum = 0;
	    
	    for (int i = 0; i < n; i++){
	        sum += a[i];
	    }
	    
	    // divide the subset 
	    boolean dp[][] = new boolean[n+1][sum+1]; // target sum
	    
	    for(int i = 0; i <= n; i++) {
	        dp[i][0] = true;
	    }
	    
	    for(int i = 1; i <= sum; i++){
	        dp[0][i] = false;
	    }
	    
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= sum/2; j++) {
	            
	            dp[i][j] = dp[i-1][j];
	            
	            if (a[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i - 1][j - a[i - 1]];
	            
	        }
	    }
	    
	    
	    for(int j = sum/2; j >= 0; j--) {
	        if (dp[n][j] == true ){
	            return sum - 2 * j;
	        }
	    }  
	    
	    return Integer.MIN_VALUE;
	    
	} 
}