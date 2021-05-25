public class LeetSingleNumer {
    
    public int singleNumber(int[] nums) {
        
        // using bit manipulation
        // if we take xor of all bits, only the bit which is not repeated will remain
        // x ^ 0 = x
        // x ^ x = 
        int a = 0;
        
        for(int i : nums){
            a ^= i;
        }
        
        return a;
    }
}
