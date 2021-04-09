package DynamicProgramming;

/**
 * EqualSubsetSum
 * return 0 if not present 
 * else return 1 if equal subset exists
 */
public class EqualSubsetSum {

    static int equalPartition(int N, int arr[])
    {
        int sum = 0; 
        
        for(int i = 0; i < N; i++)
            sum += arr[i];
         if (sum % 2 != 0)
            return 0;
            
        boolean dp[][] = new boolean[N+1][sum/2 + 1];
        
        for(int i = 0; i <= N; i++) {
	        dp[i][0] = true;
	    }
	    
	    for(int i = 1; i <= sum/2; i++){
	        dp[0][i] = false;
	    }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= sum/2; j++) {
                
                dp[i][j] = dp[i-1][j];
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i][j] ||  dp[i-1][j - arr[i-1] ];
                } 
            }
        }
        
       if(dp[N][sum/2] == true )
        return 1;
        else return 0;
    }
}