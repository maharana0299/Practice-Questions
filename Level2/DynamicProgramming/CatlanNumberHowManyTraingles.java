import java.util.*;

/**
 * This question can be reduced to catlan by subtracting by 2
 */
public class CatlanNumberHowManyTraingles {

	public static int solution(int n){
		// traingulation of 2 is 1, traingualtion of 3 is 1, 4 is 2 and so on
		// hence application of catlan number 
		if(n < 2)
		    return 0;
		// reducing to catlan 
		n = n-2;
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= n; i++) {
		    int left = i-1;
		    int right = 0;
		    
		    while(left >= 0) {
		        
		        dp[i] += dp[left] * dp[right];
		        left--;
		        right++;
		    }
		}
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}