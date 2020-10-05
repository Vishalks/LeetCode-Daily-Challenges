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
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int level = countLevel(root, 0);
        int bottomCount = traverse(root, level, 1, 0);
        return (int)Math.pow(2, level-1)-1 + bottomCount;//no of nodes till height-1 + no of nodes at last level
    }
    private int countLevel(TreeNode root, int depth) {
        if(root == null)
            return depth;
        return countLevel(root.left, depth+1);
    }
    private int traverse(TreeNode root, int deepest, int level, int count) {
        if(root == null)
            return count;
        if(deepest == level)//reached the deepest level of the tree
            return count+1;
        int localCount = traverse(root.left, deepest, level+1, count);
        localCount += traverse(root.right, deepest, level+1, count);
        return localCount;
    }
}