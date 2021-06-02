import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        int longest =  lcs_dp(s1,s2);
        // lcs_mem(new StringBuilder(s1),new StringBuilder(s2),0,0, new Integer[s1.length()][s2.length()]);
        System.out.println(longest);
    }
    
    static int lcs(StringBuilder s1, StringBuilder s2, int i, int j) {
        
        // base case 
        if(i == s1.length() || j == s2.length()) {
            // lcs for "" and a is 0 
            return 0;
        }
        
        // if first char is equal then 
        if(s1.charAt(i) == s2.charAt(j)) {
            // return lcs of next subseq from i+1 to len , j+1 to len 
            return 1 + lcs(s1,s2,i+1,j+1);
        } 
        
        // if no then we have two option
        return Math.max(lcs(s1,s2,i,j+1),lcs(s1,s2,i+1,j));
    }
    
    // qb[i][j] stores longest common subseq of s1(i to n-1) and s2(j to m-1)
    static int lcs_mem(StringBuilder s1, StringBuilder s2, int i, int j, Integer[][] qb) {
        
        // base case 
        if(i == s1.length() || j == s2.length()) {
            // lcs for "" and a is 0 
            return 0;
        }
        
        if(qb[i][j] != null)
            return qb[i][j];
            
        // if first char is equal then 
        if(s1.charAt(i) == s2.charAt(j)) {
            // return lcs of next subseq from i+1 to len , j+1 to len 
            return qb[i][j] = 1 + lcs_mem(s1,s2,i+1,j+1,qb);
        } 
        
        // if no then we have two option
        return qb[i][j] = Math.max(lcs_mem(s1,s2,i,j+1,qb),lcs_mem(s1,s2,i+1,j,qb));
    }
    
    static int lcs_dp(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        // assign meaning 
        int [][] dp = new int[n+1][m+1];
        // dp[i][j] stores the lcs from i to n-1 and j to m-1 
        // dp[0][0] will contains out final ans 
        
        // dp[n][0] and dp[0][m] will be 0
        
        for(int i = n-1; i >= 0; i--) {
            
            for(int j = m-1; j >= 0; j--) {
                
                if(s2.charAt(j) == s1.charAt(i)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
