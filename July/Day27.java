//TS: O(n)
//SC: O(n)
class Solution {
  int postIndex;
  int[] postorder;
  int[] inorder;
  HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

  public TreeNode helper(int leftIndex, int rightIndex) {
    // if there is no elements to construct subtrees
    if (leftIndex > rightIndex)
      return null;

    // pick up postIndex element as a root
    // since root is at the last position in postorder, we will get value of root
    // at the postIndex whose initial value is postOrder.length-1. This goes on decreasing
    // after each recursion call
    int rootVal = postorder[postIndex];
    TreeNode root = new TreeNode(rootVal);

    // root splits inorder list into left and right subtrees
    // since we prepared the map from inorder, we get root index from it.
    int rootIndex = indexMap.get(rootVal);

    // recursion 
    postIndex--;
    // build right subtree
    root.right = helper(rootIndex + 1, rightIndex);
    // build left subtree
    root.left = helper(leftIndex, rootIndex - 1);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    // start from the last postorder element
    postIndex = postorder.length - 1;

    // build a hashmap value -> its index
    for (int i = 0; i <= postIndex; i++)
      indexMap.put(inorder[i], i);
      
    return helper(0, postorder.length - 1);
  }
}