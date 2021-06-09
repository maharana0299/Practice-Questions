import java.io.*;
import java.util.*;

public class PrintAllGoldMine {

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
      
      printAllPath(arr);
   }
  
   static void printAllPath(int[][] arr) {
       
       int n = arr.length;
       int m = arr[0].length;
       
       // max gold that can be collected from (i,j) to end
       int dp[][] = new int[n][m];
       
       int omax = Integer.MIN_VALUE;
       
       for(int j = m-1; j >= 0; j--) {
           
           
           for(int i = n-1; i >= 0; i--) {
               
               if(j == m-1) {
                   dp[i][j] = arr[i][j];
               } else if(i == 0) {
                   // only two option
                   dp[i][j] = arr[i][j] + max(dp[i+1][j+1], dp[i][j+1] );
               } else if(i == n-1) {
                   dp[i][j] = arr[i][j] + max(dp[i][j+1],dp[i-1][j+1]);
               } else {
                   dp[i][j] = arr[i][j] + max(dp[i][j+1], dp[i+1][j+1], dp[i-1][j+1] );
               }
               
               if(j == 0) {
                   omax = max(omax,dp[i][j]);
               }
           }
           
           
       }
       
       System.out.println(omax);
       
       // npw doing reverse enn
       Queue<Pair> q = new LinkedList<>();
       
       for(int i = 0; i < n; i++) {
           if(dp[i][0] == omax) {
               q.add(new Pair(i,0, i + " ") );
           }
       }
       
       while(!q.isEmpty() ) {
           
           Pair p = q.remove();
           
           int i = p.i;
           int j = p.j;
           
           if(j == m-1) {
               System.out.println( p.psf);
           } else if(i == 0) {
               // only two option
               int max = max(dp[i+1][j+1], dp[i][j+1] );
               
               if(max == dp[i][j+1]) {
                   q.add(new Pair(i,j+1,p.psf + "d2 ") );
               }
               
               if(max == dp[i+1][j+1]) {
                   q.add(new Pair(i+1,j+1,p.psf + "d3 " ) );
               }
           } else if(i == n-1) {
               int max = max(dp[i][j+1],dp[i-1][j+1]);
               
               if(max == dp[i-1][j+1]) {
                   q.add(new Pair(i-1,j+1,p.psf + "d1 "));
               }
               
               if(max == dp[i][j+1]) {
                   q.add(new Pair(i,j+1,p.psf + "d2 ") );
               }

           } else {
               int max =  max(dp[i][j+1], dp[i+1][j+1], dp[i-1][j+1] );
               
               if(max == dp[i-1][j+1]) {
                   q.add(new Pair(i-1,j+1, p.psf + "d1 ") );
               }
               
               if(max == dp[i][j+1]) {
                   q.add(new Pair(i,j+1, p.psf + "d2 ") );
               }
               
               if(max == dp[i+1][j+1]) {
                   q.add(new Pair(i+1,j+1,p.psf + "d3 " ) );
               }
           }
       }
   }
   
   static int max(int a, int b){
       return Math.max(a,b);
   }
   
   static int max(int a, int b, int c){
       return Math.max(a,Math.max(b,c));
   }
   

}