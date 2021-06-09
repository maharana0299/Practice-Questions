import java.io.*;
import java.util.*;

public class PrintAllMinCost {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(int i, int j, String psf) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      printAllPaths(arr,n,m);
      
   }
   
   static void printAllPaths(int[][] arr, int n, int m) {
       
       // find min cost 
       int minCost;
       // stroes min cost to travel from (i,j) to (n-1,m-1)
       int[][] dp = new int[n][m];
       
       for(int i = n-1; i >= 0; i--) {
           
           for(int j = m-1; j >= 0; j--) {
                
                if(i == n-1 && j == m-1) {
                    dp[i][j] = arr[i][j];
                } else if(i == n-1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                } else if(j == m-1) {
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = arr[i][j] +  Math.min(dp[i+1][j],dp[i][j+1]);
                }
           }
       }
       
       System.out.println(dp[0][0]);
       
       // do reverse engg 
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(0,0,"") );
      while(!q.isEmpty()) {
            
            Pair p = q.remove();
            int i = p.i;
            int j = p.j;
            
          if(i == n-1 && j == m-1) {
                // dp[i][j] = arr[i][j];
                System.out.println(p.psf);
            } else if(i == n-1) {
                // dp[i][j] = arr[i][j] + dp[i][j+1];
                q.add(new Pair(i,j+1,p.psf + "H") );
            } else if(j == m-1) {
                // dp[i][j] = arr[i][j] + dp[i+1][j];
                q.add(new Pair(i+1,j,p.psf + "V") );
            } else {
                
                if(dp[i][j+1] < dp[i+1][j]){
                    q.add(new Pair(i,j+1,p.psf + "H") );
                } else if(dp[i][j+1] > dp[i+1][j] ){
                    q.add(new Pair(i+1,j,p.psf + "V") );
                } else {
                    q.add(new Pair(i+1,j,p.psf + "V") );
                    q.add(new Pair(i,j+1,p.psf + "H") );
                }
            }
      }
       
   }

}