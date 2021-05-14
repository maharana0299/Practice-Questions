import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * LongestConsecutiveSequence
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        longestConsecutive(arr);
        sc.close();
        // System.out.println(longest);
    }
    
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int num: nums) set.add(num);
        int max = 1;
        int minElement = 1;
        for(int i : nums) {
            
            if(!set.contains(i))
                continue;
            
            set.remove(i);
            int t = i+1;
            int count = 1;
            while(!set.isEmpty()) {
                if(set.contains(t)){
                    count++;
                    set.remove(t++);
                } else {
                    break;
                }
            }
            
            t = i-1;
            
            while(!set.isEmpty()) {
                if(set.contains(t)){
                    count++;
                    set.remove(t--);
                } else {
                    break;
                }
            }
            
            if(max < count) {
                max = count;
                minElement = t+1;
            }
        }
        
        for(int i = 0; i < max; i++) {
            System.out.println(minElement++);
        }
        return max;
    }

    public void printLongestConsucutiveSubsequence(int[] arr) {

        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : arr) {
            map.put(i, true);
        }

        for(int i : arr) {

            if(map.containsKey(i-1)){
                map.put(i, false);
            }
        }

        int max = 1;
        int s = 0;

        for(int i : arr) {

            if(map.get(i)) {

                int in = i+1;

                while(true) {
                    if(map.containsKey(in)){
                        in += 1;
                    } else break;
                }

                in = in-i;

                if(max < in) {
                    s = i;
                    max = in;
                }
            }
        }

        for(int i = 0; i < max; i++) {
            System.out.println(s+i);
        }
    }
    
}