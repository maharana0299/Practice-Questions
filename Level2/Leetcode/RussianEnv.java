import java.util.Arrays;

public class RussianEnv {
    
    public int maxEnvelopes(int[][] env) {

        if(env.length == 1)
            return 1;
        
        Arrays.sort(env,(a, b) -> a[0] - b[0] );
        int dp[] = new int[env.length];
        int omax = 0;
        
        for(int i = 0; i < dp.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(env[j][1] < env[i][1] && env[j][0] < env[i][0] ) {
                    max = Math.max(max,dp[j]);
                }

            }
            
            dp[i] = max + 1;
            if(omax < dp[i])

                omax = dp[i];

        }
        return omax;
    }
}
