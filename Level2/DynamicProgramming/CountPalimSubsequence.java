import java.util.*;

public class CountPalimSubsequence {
    
    // here we want to count palindromic sbsequence 
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        char[] s = (sc.nextLine()).toCharArray();
        
        int countp = cps_mem(s,0,s.length-1,new Integer[s.length][s.length]);
        System.out.println(countp);
    }
    
    static int cps_mem(char[] s, int i, int j, Integer[][] mem) {
        
        if(mem[i][j] != null)
            return mem[i][j];
        if(i > j)
            return 0;
        if(i == j)
            return mem[i][j] = 1;
        if(i == j+1) {
            if(s[i] == s[j]) {
                return mem[i][j] = 3;
            } else {
                return mem[i][j] = 2;
            }
        }
        
        if(s[i] == s[j]) {
            /*
            for aba 
            a
            b
            aba
            b
            a
            ie, 2 + 2 + 1
            */
            return mem[i][j] = cps_mem(s,i+1,j,mem) + cps_mem(s,i,j-1,mem) + 1;
        } else {
            /*
            abc
            a
            b
            b
            c
            */
            return mem[i][j] = cps_mem(s,i+1,j,mem) + cps_mem(s,i,j-1,mem) - cps_mem(s,i+1,j-1,mem);
        }
    }
    
    static int cps_rec(char[] s, int i, int j) {
        
        if(i > j)
            return 0;
        if(i == j)
            return 1;
        if(i == j+1) {
            if(s[i] == s[j]) {
                return 3;
            } else {
                return 2;
            }
        }
        
        if(s[i] == s[j]) {
            /*
            for aba 
            a
            b
            aba
            b
            a
            ie, 2 + 2 + 1
            */
            return cps_rec(s,i+1,j) + cps_rec(s,i,j-1) + 1;
        } else {
            /*
            abc
            a
            b
            b
            c
            */
            return cps_rec(s,i+1,j) + cps_rec(s,i,j-1) - cps_rec(s,i+1,j-1);
        }
    }
    
    static int cps(char[] s) {
        
        int n = s.length;
        
        // dp[i][j] stores the palindromic subsequence of s[i...j]
        int[][] dp = new int[n][n];
        
        for(int g = 0; g < n; g++) {
            
            for(int i = 0, j = g; j < n; i++,j++ ) {
                
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    
                    if(s[i] == s[j]) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = 2;
                    }
                    
                } else {
                    
                    if(s[i] == s[j]) {
                        dp[i][j] = 1 + dp[i][j-1] + dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i+1][j] - dp[i+1][j-1] + dp[i][j-1] ;
                    }
                }
            }
        }
        return dp[0][n-1];
    }

}