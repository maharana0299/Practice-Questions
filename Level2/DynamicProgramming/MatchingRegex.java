import java.util.Scanner;

public class MatchingRegex {

	public static boolean solution(String st, String pt) {
		
		pt = "#" + pt;
		st = "#" + st; 
		int n = pt.length();
		int m = st.length();
		
		char[] s = st.toCharArray();
		char[] p = pt.toCharArray();
		
		boolean[][] dp = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
		    for(int j = 0; j < m; j++) {
		        
		        // matching pattern
		        if(i == 0 && j == 0) {
		            dp[i][j] = true;
		        }
		        else if(i == 0) {
		            dp[i][j] = false;
		        } else if(j == 0) {
		            if(p[i] == '*')
		                dp[i][j] = dp[i-2][j];
		        } else {
		            
		            if(p[i] == '.') {
		                dp[i][j] = dp[i-1][j-1];
		            } else if(p[i] == '*') {
		                
		                dp[i][j] = dp[i-2][j];
		                
		                if(p[i-1] == '.' || p[i-1] == s[j]) {
		                    dp[i][j] = dp[i][j] || dp[i][j-1];
		                }
		            } else {
		                if(p[i] == s[j]) {
		                    dp[i][j] = dp[i-1][j-1];
		                }
		            }
		        }
		    }
		}
		
		return dp[n-1][m-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}