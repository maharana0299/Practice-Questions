package DynamicProgramming;
/**
 * MinJump
 */
public class MinJump {

    static int minJumps(int[] arr){
        
        int jumps = 0; 
        int currend = 0;
        int currfar = 0;
        int n = arr.length;
        
        int[] dp = new int[n];
        
        for(int i = 0; i < n-1; i++) {
            
            currfar = Math.max(currfar,i+arr[i]);
            
            if(i == currend) {
                jumps++;
                currend = currfar;
            } else 
            dp[i] = jumps;
            if (currend >= n-1) {
                dp[n-1] = jumps;
            }
        }
        
        if (currend < n-1)
            return -1;
        return dp[n-1];
    }
}