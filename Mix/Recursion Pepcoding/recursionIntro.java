import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class recursionIntro {
    public static void main(String...args){

    }

    public static void printDecreasing(int n){
        if ( n <= 0)
            return;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if  (n <= 0)
            return;
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if (n <= 1)
            return 1;
        return n * factorial(n-1);
    }

    public static int power(int x, int n){
        if ( x == 0)
            return 0;
        if (n == 0)
            return 1;

        return x * power(x,n-1);
    }
}

class LeetcodePermutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int size = nums.length;

        permutation(new int[size],1,size,nums,ls);

        return ls;
    }

    private void permutation(int[] perms, int ci, int r, int[] arr, List<List<Integer>> ls) {
        if (ci > r) {
            ls.add(Arrays.stream(perms).boxed().collect(Collectors.toList()) );
            return ;
        }

        for (int i = 0; i < r; i++){
            if (perms[i] == 0) {
                perms[i] = arr[ci - 1];
                permutation(perms, ci + 1, r, arr, ls);
                perms[i] = 0;
            }
        }
    }

    public static void printZingZag(){
        
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // fsf is fpund so far
        // two way recursion 
        
        if (idx == arr.length)
            return new int[fsf];
        if (arr[idx] == x ){
            int[] i = allIndices(arr, x, idx + 1, fsf + 1);
            i[fsf] = idx;
            return i;
        }
        else {
            int[] i = allIndices(arr, x, idx + 1, fsf);
            return i;
        }
    }
}