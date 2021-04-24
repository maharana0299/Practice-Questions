/**
 * BSTToGreaterTree
 */
public class BSTToGreaterTree {

    TreeNode prevMax = null;
    public TreeNode convertBST(TreeNode root) {
        // for a root node, left side is less and roght side is greater
        
        if(root == null)
            return null;
        
        convertBST(root.right);
        
        if(prevMax != null)
        root.val = root.val + prevMax.val;
        
        prevMax = root;
        
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBSTusingStack(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }
}


 
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
