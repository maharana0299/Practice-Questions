package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * SortKSorted
 */
public class SortKSorted {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for(int i = k+1; i < n; i++) {
            
            System.out.println(pq.poll());
            
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}