//TC: O(logn) = O(h) where h is height of the tree
//SC: O(1)
class Solution {
  public Node inorderSuccessor(Node x) {
    // the successor is the leftmost leaft in the right subtree
    if (x.right != null) {
      x = x.right;
      while (x.left != null)
          x = x.left;
      return x;
    }

    // the successor is somewhere upper in the tree
    while (x.parent != null && x == x.parent.right)
        x = x.parent;
    return x.parent;
  }
}