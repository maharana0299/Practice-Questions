import java.util.*;

public class LISRussianDoll {

    public static void main(String[] args) throws Exception {
        
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of envelopes 
        Envelope[] envlps = new Envelope[n];
        
        for(int i = 0; i < n; i++) {
            envlps[i] = new Envelope();
            envlps[i].width = sc.nextInt();
            envlps[i].height = sc.nextInt();
        }
        
        int maxEnvplsInside = findMaxEnvelopesNested(envlps);
        System.out.println(maxEnvplsInside);
    }
    
    // this is also an application of LIS
    public static int findMaxEnvelopesNested(Envelope[] envlps) {
        
        // sort 
        Arrays.sort(envlps);
        
        // find lis for heigth
        int[] dp = new int[envlps.length];
        int omax = 0;
        
        for(int i = 0; i < envlps.length; i++) {
            
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(envlps[j].height < envlps[i].height && envlps[j].width < envlps[i].width) {
                    max = Math.max(max,dp[j]);
                }
            }
            
            dp[i] = 1 + max;
            
            if(dp[i] > omax) {
                omax = dp[i];
            }
        }
        
        return omax;
    }
    
    private static class Envelope implements Comparable<Envelope> {
        
        int width;
        int height;
        
        Envelope(){}
        
        public int compareTo(Envelope o) {
            return this.width - o.width; // sort in ascending order
        }
        
    }

}