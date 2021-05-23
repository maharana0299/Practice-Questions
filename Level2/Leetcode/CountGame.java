package Leetcode;

class CanJum{
    public boolean canJump(int[] A) {
        
        // greedy approach
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }
}