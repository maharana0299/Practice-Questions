import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteness {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isNull = false;
        
        while(!q.isEmpty()){
            
            int n = q.size();
            
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
            if( node.left != null ){
                if(isNull)   return false; 
                q.add(node.left);
            }
            else
                isNull = true;
                
            if( node.right != null ){
                if(isNull)   return false;
                q.add(node.right);
            }
            else
                isNull = true;
            }
        }        
        
        return isNull;
    }
}

