public class BSTFromPreorder {
    
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    private class Solution {
    
        int index = 0;
        public TreeNode bstFromPreorder(int[] preorder) {
            
            index = 0; // initially
            
            // ranges;
            int lr = Integer.MIN_VALUE; // initilally
            int rr = Integer.MAX_VALUE; // initially 
            TreeNode node = buildFromPre(preorder,lr,rr);
            return node;
        }
        
        TreeNode buildFromPre(int[] pre, int lr, int rr) {
            
            if(index >= pre.length || lr > pre[index] || rr < pre[index])
                return null; // invalid cases
            
            // if valid, then 
            TreeNode node = new TreeNode(pre[index++]);
            node.left = buildFromPre(pre,lr,node.val); // rr will now be node.val
            node.right = buildFromPre(pre,node.val,rr);
            
            return node;
        }
    }
}
