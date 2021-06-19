import java.util.*;

public class MinCutPalindrome {
    
    // using left-right strategy and it runs in complexity of o(ne3)
	public static int minPalindromicCutLR(String s) {
		
		int n = s.length();
		// dp to stores is palindrome 
		boolean[][] isPalin = buildIsPalindp(s,n);
		
		int[][] minP = new int[n][n];
		
		// gap-2
		for(int g = 0; g < n; g++) {
		    for(int i = 0, j = g; j < n; i++,j++){
		        
		        if(g ==0){
		            minP[i][j] = 0;
		        } else if(g == 1) {
		            if(s.charAt(i) == s.charAt(j)){
		                minP[i][j] = 0;
		            } else {
		                minP[i][j] = 1;
		            }
		        } else {
		            
		            if(isPalin[i][j]){
		                minP[i][j] = 0; // if already palindrome
		            } else {
    		            int min = Integer.MAX_VALUE;
    		            // using gap strategy 2 with little varaiton 
    		            for(int k = i; k < j; k++){
    		                int v = minP[i][k] + // left part
    		                        minP[k+1][j]; // right part
    		                if(min > v){
    		                    min = v;
    		                }
    		            }
    		            
    		            minP[i][j] = 1 + min; // min plus one cut we made
		            }
		        }
		    }
		}
		return minP[0][n-1];
	}
	
	// optimized way using suffix palin 
	
	public static int minPalindromicCut(String s){
	    
	    int n = s.length();
	    boolean[][] isPalin = buildIsPalindp(s,n);
	    
	    // min p from 0 to i
	    int[] dp = new int[n];
	    dp[0] = 0;
	    
	    for(int j = 1; j < n; j++) {
	        // if already a palin 
	        if(isPalin[0][j]){
	            dp[j] = 0;
	        } else {
	            int min = Integer.MAX_VALUE;
	            for(int i = j; i > 0; i--){
	                // is suffix palndrome 
	                if(isPalin[i][j]) {
	                    if(dp[i-1] < min){
	                        min = dp[i-1];
	                    }
	                }
	            }
	            dp[j] = min + 1;
	        }
	    }
	    
	    return dp[n-1];
	}
	static boolean[][] buildIsPalindp(String s, int n){
	    
	    boolean[][] dp = new boolean[n][n];
	    for(int g = 0; g < n; g++) {
		    for(int i = 0, j = g; j < n; i++,j++){
		        
		        if(g == 0){
		            dp[i][j] = true;
		        } else if(g == 1){
		            dp[i][j] = s.charAt(i) == s.charAt(j);
		        } else {
		            if(s.charAt(i) == s.charAt(j)){
		                dp[i][j] = dp[i+1][j-1];
		            } else {
		                dp[i][j] = false;
		            }
		        }
		    }
		}
		return dp;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}