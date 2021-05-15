package BinaryTree;

class Solution {
    int totalTilt;
    public int findTilt(TreeNode root) {
     
        if(root == null)
            return 0;
        
        totalTilt=0;
        tiltSum(root);
        return totalTilt;
    }
    
    public int tiltSum(TreeNode root){
        
        if(root == null)
            return 0;
        
        int ls = tiltSum(root.right);
        int rs = tiltSum(root.left);
        
        totalTilt += Math.abs(rs-ls);
        return ls + rs + root.val;
    }
}