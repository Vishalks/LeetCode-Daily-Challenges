//SC: O(h) for next and O(1) for hasNext
//TC: O(1) for both
class BSTIterator {
    Stack<TreeNode> s;
    TreeNode currentNode;

    public BSTIterator(TreeNode root) {
        s = new Stack();
        currentNode = root;
    }
    
    /** @return the next smallest number */
    //similar to iterative inorder traversal
    //This first while condition in interative inorder traversal is used in hasNext while rest of the part is used here
    public int next() {
        while(currentNode != null){
            s.push(currentNode);
            currentNode = currentNode.left;
        }
        currentNode = s.pop();
        int val = currentNode.val;
        currentNode = currentNode.right;
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty() || currentNode != null;
    }
}