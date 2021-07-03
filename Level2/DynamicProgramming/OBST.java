import java.util.*;

public class OBST {
  
    private static void optimalbst(int[] keys, int[] fr, int n) {
        
        int[][] dp = new int[n][n];
        
        int pre[] = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                pre[i] = fr[i];
                continue;
            }
            pre[i] = pre[i-1] + fr[i];
        }
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++,j++){
                
                if(g == 0){
                    dp[i][j] = fr[i];
                } else if(g == 1){
                    int f1 = fr[i];
                    int f2 = fr[j];
                    
                    dp[i][j] = Math.min(f2*2+f1,f1*2+f2);
                } else{
                    
                    int min = Integer.MAX_VALUE;
                    int fs = i == 0 ? pre[j] : pre[j] - pre[i-1];
                    
                    for(int k = i; k <= j; k++){
                        
                        int left = (k == i) ? 0 : dp[i][k-1];
                        int right = (k == j) ? 0 : dp[k+1][j];
                        
                        if(left + right + fs < min){
                            min = left + right + fs;
                        }
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        System.out.println(dp[0][n-1]);
    }
    
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for(int i= 0 ;i < n ; i++) {
        	keys[i] = scn.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys,frequency,n);
    }

}