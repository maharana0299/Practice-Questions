import java.util.*;

public class LCSLongestRepeating {

	public static int solution(String str){
		
		int n = str.length()+1;
		int dp[][] = new int[n][n];
		
		for(int i = n-1; i >= 0; i--){
		    for(int j = n-1; j >= 0; j--){
		        if(i == n-1 && j == n-1){
		            dp[i][j] = 0;
		        } else if(i == n-1 || j == n-1){
		            dp[i][j] = 0;
		        } else {
		            if(str.charAt(i) == str.charAt(j)  && i != j ){
		                dp[i][j] = 1 + dp[i+1][j+1];
		            } else {
		                dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
		            }
		        }
		    }
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}