
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * KLargestElement
 */
public class KLargestElement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());

        List<Integer> ele = getKLargestElement(arr,k);
        
        for(int i : ele){
            System.out.println(i);
        }
      }

    private static List<Integer> getKLargestElement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : arr) {
            pq.add(i);
        }

        List<Integer> ls = new LinkedList<>();

        while(k-- > 0 ){
            ls.add(0,pq.poll());
        }

        
        return ls;
    }

}