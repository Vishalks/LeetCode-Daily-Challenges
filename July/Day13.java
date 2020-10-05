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
//TC: O(n) - each node has to be visited
//SC: O(n) - number of stacks for recursive function call
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null)
            return false;
        if(p != null && q == null)
            return false;
        if(p == null && q == null)
            return true;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}