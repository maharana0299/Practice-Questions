import java.io.*;
import java.util.*;

public class PrintAllTargetSum {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        printAllTargetSum(arr,tar);
    }
    
    static void printAllTargetSum(int[] arr, int tar) {
        
        // 0 to ith , can make target j 
        boolean[][] dp =  new boolean[arr.length+1][tar+1];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                
                if(j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else {
                    
                    dp[i][j] = dp[i-1][j]; // can i-1 th element make a target
                    
                    if(j-arr[i-1] >= 0) {
                        dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                    }
                }
            }
        }
        
        System.out.println(dp[arr.length][tar] );
        
       
        // now doing revere engg 
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(arr.length,tar,""));
      

        while (q.size() > 0) {
			Pair rp = q.remove();
			if (rp.i == 0 || rp.j == 0) {
				System.out.println(rp.psf);
			} else {
				boolean exc = dp[rp.i - 1][rp.j];
				boolean inc = rp.j - arr[rp.i - 1] >= 0 ? dp[rp.i - 1][rp.j - arr[rp.i - 1]] : false;
				
				if (inc == true) {
					q.add(new Pair(rp.i - 1, rp.j - arr[rp.i - 1], (rp.i - 1) + " " + rp.psf));
				}
				if (exc == true) {
					q.add(new Pair(rp.i - 1, rp.j, rp.psf));
				}
			}
		}
    }
}


 