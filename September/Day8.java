//SC: O(n) for recusrive function calls
//TC: O(n) since we visit each node once
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = val * 2 + root.val;//convert binary to decimal
        if(root.left == null && root.right == null)//reached leaf so return val
            return val;
        return dfs(root.left, val) + dfs(root.right, val);//call dfs on left and right child
    }
}