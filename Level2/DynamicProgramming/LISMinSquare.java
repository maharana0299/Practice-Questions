import java.util.*;

/**
 * Min square numbers needed to MAKE a number n, eg : 10 = 3^2 + 1, min num = 2
 */
public class LISMinSquare {
    
    // this is also an application of lis 
	public static int solution(int n){
		
		// dp[i] stores sq. numbers req to form i 
		int dp[] = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
	
		// calculating LIS
		for(int i = 2; i <= n; i++) {
		    
		    int min = Integer.MAX_VALUE;
		    for(int j = 1;  j*j <= i; j++) {
		        
		        int rem = i - j*j;
		        
		        if(min > dp[rem]) {
		            min = dp[rem];
		        }
		    }
		    
		    dp[i] = min+1;
		   
		}
		return dp[n]; // ways to make n 
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}
	
}