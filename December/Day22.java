
//SC: O(h), height of recursion stack
//TC: O(n), since we visit each node only once
class Solution {
    
    //SC: O(h), h is height of tree
    //TC: O(n^2), since for each node, we first calculate height of left and right subtree and height calculation is O(n)
    /*
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;
    }
    
    public int height(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    */
    
    public boolean isBalanced(TreeNode root){
        return dfs(root) != -1;
    }
    
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = dfs(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = dfs(root.right);
        if(rightHeight == -1)
            return -1;
        
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}