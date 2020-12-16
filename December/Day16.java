//SC: O(h) for recursion stacks
//TC: O(n) since we visit every node once
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long lowerLimit, long upperLimit){
        if(root == null)
            return true;
        if(root.val <= lowerLimit || root.val >= upperLimit)
            return false;
        return helper(root.left, lowerLimit, root.val) && helper(root.right, root.val, upperLimit);
    }
}