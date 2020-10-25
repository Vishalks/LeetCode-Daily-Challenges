
//SC: O(n) due to recursion stack space
//TC: O(n) since each node is visited only once
class Solution {
    public int minDepth(TreeNode root) {
        return helper(root);
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1 + helper(root.right);
        if(root.right == null)
            return 1 + helper(root.left);
        return 1 + Math.min(helper(root.left), helper(root.right));
    }
}