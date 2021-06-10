import java.util.*;

public class MathcingWlidCard {

	public static boolean solution(String str, String pattern) {
		
		/**
		 * dp -> dooes i  to n matches with j  to m
		 * Bottom up approach
		 * * -> can have 0 or m chars, dp[i][j] = dp[i+1][j] || dp[i+1][j+1] || .... || dp[i+1][m]
		 * There can be optimization for *,
		 * if i,j+1 is true, then there contains true in bottom, hence i,j will also be true
		 * So, * > dp[i][j] = dp[i+1][j] || dp[i][j+1]dd
		 * ? -> dp[i][j] = dp[i+1][j+1]
		 * ch -> str[i] == pattern[j] && dp[i+1][j+1]
		 * */
		 
		 // from pattern[i..n] matches with str[j..m]
		 int n = pattern.length();
		 int m = str.length();
		 
		 
		 boolean[][] dp = new boolean[n+1][m+1];
		 
		 for(int i = n; i >= 0; i--) {
		     for(int j = m; j >= 0; j--) {
		         
		         if(i == n && j == m) {
		             dp[i][j] = true;
		         } else if(i == n ) {
		             dp[i][j] = false;
		         } else if(j == m ){
		             if(pattern.charAt(i) == '*' )
		                dp[i][j] = dp[i+1][j];
		         } else {
		             
		             char ch = pattern.charAt(i);
		             
		             if(ch == '?'){
		                 dp[i][j] = dp[i+1][j+1];
		             } else if(ch == '*') {
		                 dp[i][j] = dp[i+1][j] || dp[i][j+1];
		             } else if(ch == str.charAt(j)) {
		                 dp[i][j] = dp[i+1][j+1];
		             } else {
		                 dp[i][j] = false;
		             }
		         }
		     }
		 }
		 
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}