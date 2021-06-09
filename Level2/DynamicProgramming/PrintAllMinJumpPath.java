import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PrintAllMinJumpPath{
    public static void Solution(int arr[]){
        
        // calculate min jumps  from 0 to n-1 th step 
        int n = arr.length;
        Integer[] dp = new Integer[n]; // makind dp of size n
        dp[n-1] = 0; // from n-1 to n-1 is zero 
        
        for(int i = n-2; i >= 0; i--) {
            int js = arr[i];
            
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= js && i + j < n; j++) {
                if(dp[i+j] != null && dp[i+j] < min)
                   min = dp[i+j];
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }
        }
        
        System.out.println(dp[0]);
        // doing BFS
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,arr[0],dp[0],0 + ""));
        
        while(! q.isEmpty()) {
            
            Pair rem = q.remove();
            
            if(rem.minJump == 0) {
                System.out.println(rem.psf + " .");
            }
            for(int i = 1; i <= rem.jumps && i + rem.i < n; i++) {
                int ci = i + rem.i; 
                if(dp[ci] != null && dp[ci] == rem.minJump-1) {
                    q.add(new Pair(ci,arr[ci],dp[ci],rem.psf + " -> " + ci));
                }
            } 
        }
    }
    
    // class pair 
    private static class Pair {
        
        int i;
        int jumps;
        int minJump;
        String psf;
        
        Pair(int i, int v, int j, String psf) {
            this.i = i;
            this.minJump = j;
            this.jumps = v;
            this.psf = psf;
        }
    }
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
