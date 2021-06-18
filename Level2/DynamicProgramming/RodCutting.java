import java.util.*;

public class RodCutting {

    // there are two strategy 
    // cut starategy (cut k size and find max of n-k size ), return max of all possible
    // left right strategy (find max of left and right side and add them) 
    
    // left right stategy with mem 
    static int[] mem;
    public static int rodCuttingLRMem(int[] prices, int n) {
        
        if(n <= 0) {
            return 0;
        }
        
        if(mem[n] != 0)
            return mem[n];
            
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n/2; i++) {
            int val = rodCuttingLRMem(prices,i) + rodCuttingLRMem(prices,n-i);
            if(max < val){
                max = val;
            }
        }
        
        max = Math.max(max,prices[n-1]);
        return mem[n] = max;
    }
    
    // now cut staratey with memoization
    public static int rodCuttingMem(int[] prices, int n) {
        
        if(n == 0) {
            return 0;
        }
        
        if(mem[n] != 0){
            return mem[n];
        }
        
        int max = prices[n-1];
        
        for(int i = 1; i <= n; i++) {
            
            int val = prices[i-1] + rodCuttingMem(prices,n-i);
            if(val > max) {
                max = val;
            }
        }
        
        return mem[n] = max;
    }
    
    // left right strategy
    public static int rodCuttingtLRDP(int[] prices) {
        
        int n = prices.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = prices[i-1];
            for(int j = 1; j <= i/2; j++) {
                int v = dp[j] + dp[i-j];
                if(dp[i] < v){
                    dp[i] = v;
                }
            }
        }
        return dp[n];
    }
    
    // cut strategy
    public static int rodCuttingCut(int[] prices) {
        
        int n = prices.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = prices[i-1];
            for(int j = 1; j < i; j++) {
                int v = prices[j-1] + dp[i-j];
                if(dp[i] < v){
                    dp[i] = v;
                }
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
          prices[i] = scn.nextInt();
        }
        
        mem = new int[n+1];
        System.out.println(rodCuttingCut(prices));
    }

}