import java.util.Scanner;

public class LPSLongestPalindromicSubsequence {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        // int lmax = lps_mem(s,0,s.length()-1,new Integer[s.length()][s.length()]);
        int lmax = lps_dp(s.toCharArray());
        System.out.println(lmax);
    }
    
    static int lps(String s, int l, int h) {
        
        if(l == h)
            return 1;
        if (s.charAt(l) == s.charAt(h) && l + 1 == h) {
            return 2;
        }
        if(s.charAt(l) == s.charAt(h)) {
            return 2 + lps(s,l+1,h-1);
        } else {
            return Math.max(lps(s,l,h-1),lps(s,l+1,h));
        }
    }
    
    // mem -> (i,j) -> lps inclduing i and j 
    // mem[l][h] when l == h will store 1 , coz a is a palindrome 
    // mem[l][l+1] and char at l and h equal wil store 2 coz aa is not a palindrome 
    static int lps_mem(String s, int l, int h,Integer[][] mem) {
        
        if(mem[l][h] != null)
            return mem[l][h];
            
        if(l == h)
            return mem[l][h] = 1;
        if (s.charAt(l) == s.charAt(h) && l + 1 == h) {
            return mem[l][h] = 2;
        }
        if(s.charAt(l) == s.charAt(h)) {
            return mem[l][h] = 2 + lps(s,l+1,h-1);
        } else {
            return mem[l][h] = Math.max(lps(s,l,h-1),lps(s,l+1,h));
        }
    }
    
    static int lps_dp(char[] s) {
        
        int n = s.length;
        // dp[i][j] stores then longes palindromic subsequence including ith and jth character
        // out answer will be stored at dp[0][n-1];
        int dp[][] = new int[n][n];
        
        // dependency ->  
        // dp[i][j] = max(dp[i+1][j],dp[i][j+1)
        // dp[i][j] when s[i] == s[j], = 2 + dp[i+1][j-1]
        // dp[i][i+1] when s[i] == s[j] = 2
        
        for(int gap = 0; gap < n; gap++) {
            
            for(int i = 0, j = i + gap; i < n && j < n; i++,j++){
                if(gap == 0) {
                    dp[i][j] = 1;
                } else if(gap == 1) {
                    if(s[i] == s[j]) {
                        dp[i][j] = 2;
                    } else {
                      dp[i][j] = 1;  // coz in ab lps is 1
                    }
                } else {
                    if(s[i] == s[j]) {
                        dp[i][j] = 2 + dp[i+1][j-1]; // which is already solved
                    } else dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
