/* we should be traversing from the children to the parent and calculate the
 * height from bottom. So the null nodes would have height 0. The leaf nodes would have the
 * height 1 and the root would have the max height.
 
 * At each node, we keep a pair<height_of_node_from_bottom, node>. At a given node, if we
 * realize that the leftHeight == rightHeight, it means we have found the deepest subtree
 * rooted at node. If leftHeight > rightHeight, it means the deepest subtree must be rooted
 * at left child. If rightHeight > leftHeight, it means the deepest subtree must be rooted
 * at right child.
 
 * Postorder traversal allows us to traverse from bottom-up so we use it in the code.
 */
//SC: O(h), depth of recursion tree
//TC: O(n) since we traverse each node once
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return height(root).getValue();
    }
    
    private Pair<Integer, TreeNode> height(TreeNode root) {
        if (root == null)
            return new Pair(0, null);
        
        Pair<Integer, TreeNode> left = height(root.left);
        Pair<Integer, TreeNode> right = height(root.right);
        
        int leftHeight = left.getKey();
        int rightHeight = right.getKey();
        
        if (leftHeight == rightHeight) {
            return new Pair(leftHeight + 1, root);
        }
        else if (leftHeight < rightHeight) {
            return new Pair(rightHeight + 1, right.getValue());
        }
        else {
            return new Pair(leftHeight + 1, left.getValue());
        }
    }
}