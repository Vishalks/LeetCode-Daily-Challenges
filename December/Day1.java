//SC: O(n) for function calls
//TC: O(n) since we traverse each node only once
class Solution {
    public int maxDepth(TreeNode root) {
      return helper(root);  
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)//leaf node
            return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        return 1 + Math.max(left, right);//return max among depth of left and right subtree
    }
}