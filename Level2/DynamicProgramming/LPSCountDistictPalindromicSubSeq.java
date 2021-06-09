import java.util.*;

public class LPSCountDistictPalindromicSubSeq {
    
    /**
     * array conting index of next similar character 
     * @param str
     * @return
     */
    static int[] createNextArray(String str) {
        
        Map<Character, Integer> nextIndex = new HashMap<>();
        int [] next = new int[str.length()];
        
        for(int i = str.length()-1; i >= 0; i--) {
            
            char ch = str.charAt(i);
            if(!nextIndex.containsKey(ch)) {
                next[i] = -1;
            } else {
                next[i] = nextIndex.get(ch);
            }
            
            nextIndex.put(ch,i);
        }
        return next;
    }
    
    /**
     * array containing prev similar element of the string 
     * @param str
     * @return
     */
    static int[] createPrevArray(String str) {
        
        Map<Character, Integer> prevIndex = new HashMap<>();
        int [] prev = new int[str.length()];
        
        for(int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            if(!prevIndex.containsKey(ch)) {
                prev[i] = -1;
            } else {
                prev[i] = prevIndex.get(ch);
            }
            
            prevIndex.put(ch,i);
        }
        return prev;
    }
	
    public static int countDistinctPalindromicSubsequence(String str) {
		
		int n = str.length();
		int prev[] = createPrevArray(str);
		int next[] = createNextArray(str);
		
		// print(next);
		int dp[][] = new int[n][n];
		
        /**
         * Remember this formula is derived from set theory
         * set of all distinct palindromic subsequence in s, dps(s) = s1 U s2 U s3 U s4
         * By simplyfing the numbers from this formula, we can derive all of these equations 
         */
		for(int g = 0; g < n; g++) {
		    
		    for(int i = 0, j = g; j < n; i++,j++) {
		        
		        char f = str.charAt(i);
		        char l = str.charAt(j);
		        
		        if(g == 0) {
		            dp[i][j] = 1;
		        } else if(g == 1) {
		             dp[i][j] = 2;
		        } else {
		            
		            if(f != l) {
		                dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
		            } else {
		                int ni = next[i];
		                int pi = prev[j];
		                
		                if(ni > pi) {
		                    // no c in middle 
		                    dp[i][j] = 2 * dp[i+1][j-1] + 2; 
		                } else if(ni == pi) {
		                    // 1 c in middle 
		                    dp[i][j] = 2 * dp[i+1][j-1] + 1 ;
		                } else {
		                    // more than 2 c in middle 
		                    dp[i][j] = 2 * dp[i+1][j-1] - dp[ni+1][pi-1];
		                }
		            }
		        }
		    }
		}
		
		return dp[0][n-1];
	}
	
	static void print(int[] arr) {
	    for(int i = 0; i < arr.length; i++){
	        System.out.print(arr[i] + "\t");
	    }    
	    System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(countDistinctPalindromicSubsequence(str));
	}
}
