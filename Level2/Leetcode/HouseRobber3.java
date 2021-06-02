public class HouseRobber3 {
    
    public int rob(TreeNode root) {
        int[] maxVal = dpRob(root);
        return Math.max(maxVal[0], maxVal[1]);
    }
    
    // here we are having a faith that this function will return both cases that is, if included then max and if not included  then what 
    public int[] dpRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int[] maxVal = new int[2];//maxVal[0] store the max value without robing current node, maxVal[1] store the max value with robing current node,
            int[] leftMax = dpRob(root.left);
            int[] rightMax = dpRob(root.right);
            maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
            maxVal[1] = leftMax[0] + rightMax[0] + root.val;
            return maxVal;
        }
    }

    // recursive naive tle 
    // -1 -> parent doesnt robbed 
    // 1 -> parent robbed
    public int dfs(TreeNode root, int f) {
        
        if(root == null)
            return 0;
        int max = 0;
        if(f == -1) {
            // ie not robbed parent 
            int m1 = root.val + dfs(root.left,1) + dfs(root.right,1); //  choose to rob this house 
            int m2 = dfs(root.left,-1) + dfs(root.right,-1); // didnt rob this house 
            max = Math.max(m1,m2);
        } else {
            // if parent robbed then only one option
            max = dfs(root.left,-1) + dfs(root.right,-1); // not rob this
        }
        
        return max;
    }
    
    private class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;
    }
}
