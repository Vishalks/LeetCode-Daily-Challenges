//SC: O(n)
//TC: O(n)
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    
    public int helper(TreeNode root, int low, int high){
        if(root == null)
            return 0;
        //since root.val < low, call helper on the right subtree as we don't need to consider left subtree anymore
        if(root.val < low)
            return helper(root.right, low, high);
        //since root.val > high, call helper on the left subtree as we don't need to consider right subtree anymore
        if(root.val > high)
            return helper(root.left, low, high);
        //call helper on both subtree, add their call values to root.val 
        return root.val + helper(root.left, low, high) + helper(root.right, low, high);
    }
}