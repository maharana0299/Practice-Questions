package DynamicProgramming;

/**
 * EditDistance
 */
public class EditDistance {
    
    public int editDistance(String s, String t) {
        
        int l1 = s.length();
        int l2 = t.length();
        int dp[][] = new int[l1+1][l2+1];
        
        
        for (int j = 0; j<= l2; j++) {
            for (int i =0; i <= l1; i++) {
                
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                  dp[i][j] = i;  
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                   dp[i][j] = 1 + min(
                        dp[i][j-1], // insert
                        dp[i-1][j],  // delete
                        dp[i-1][j-1]); // pop
                }
            }
        }
    
        return dp[l1][l2];
    }
    
    public static int min(int x, int y, int z){
        int min = x;
        
        if (min > y)
            min = y;
        if (min > z)
            min = z;
        return min;
    }
    
}