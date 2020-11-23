//SC: O(n) for recursive calls
//TC: O(n) since we visit each node only once
class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        // the first element denotes the maximum amount of money that can be robbed if root is not robbed, while the second element signifies the maximum amount of money robbed if it is robbed
        return Math.max(result[0], result[1]);
    }
    
    public int[] helper(TreeNode root){
        if(root == null)
            return new int[2];
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int[] result = new int[2];
        //For the 1st element of rob(root), we only need to sum up the larger elements of rob(root.left) and rob(root.right), respectively, since root is not robbed and we are free to rob its left and right subtrees. For the 2nd element of rob(root), however, we only need to add up the 1st elements of rob(root.left) and rob(root.right), respectively, plus the value robbed from root itself, since in this case it's guaranteed that we cannot rob the nodes of root.left and root.right
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        
        return result;
    }
}