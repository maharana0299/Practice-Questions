package DynamicProgramming;

/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {

    static int longestSubsequence(int n, int a[]){
        
        int pile[] = new int[n];
        int len  = 0;
        pile[0] = a[0];
        
        len = 1;
        
        for(int i = 1; i < n; i++) {
            
            if (a[i] < pile[0]) {
                pile[0] = a[i];
            } else if (a[i] > pile[len-1]){
                pile[len++] = a[i];
            } else {
                // in between 
                // time to extend and replace
                
                int index = findCeilIndex(pile,-1,len-1,a[i]);
                
                pile[index] = a[i];
            }
        }
        
        return len;
    }
    
    public static int findCeilIndex(int A[], int l, int r, int key) { 

        while (r - l > 1) { 
            int m = l + (r - l) / 2;  // to prevent the overflow of left + right
            if (A[m] >= key) 
                r = m; 
            else l = m; 
        } 
        
        return r; 

    } 
}