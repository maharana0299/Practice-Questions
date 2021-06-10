import java.io.*;
import java.util.*;

public class PrintAllKnapsack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        printAllKnapSack(wts,values,cap);
        
    }
    
    static void printAllKnapSack(int wts[], int vals[], int cap) {
        
        int n = wts.length;
        // till i max can be collected with max wt of j
        int dp[][] = new int[n+1][cap+1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= cap; j++) {
                
                if(j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else {
                    
                    dp[i][j] = dp[i-1][j]; // exclude
                    
                    if(j >= wts[i-1]) {
                        
                        if(dp[i-1][j - wts[i-1]] + vals[i-1] > dp[i][j]) {
                            dp[i][j] = dp[i-1][j - wts[i-1]] + vals[i-1];
                        }
                    }
                }
            }
        }
        
        System.out.println(dp[n][cap]);
        
        // now doing rverse engg
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(n,cap,""));
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            
            
            if(p.i == 0 || p.j == 0) {
                System.out.println(p.psf);
    
            } else {
        
                if(p.j >= wts[p.i-1]) {
                    int inc = dp[p.i-1][p.j - wts[p.i-1]] + vals[p.i-1];
                    if(dp[p.i][p.j] == inc) {
                        q.add(new Pair(p.i-1, p.j-wts[p.i-1], (p.i-1) + " " +  p.psf));
                    } 
                }
                int excl = dp[p.i-1][p.j];
                
                if(dp[p.i][p.j] == excl) {
                    q.add(new Pair(p.i-1, p.j, p.psf));
                }

            }
            
        }
        
    }
    
    private static class Pair {
        
        int i;
        int j;
        String psf;
        
        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
}
