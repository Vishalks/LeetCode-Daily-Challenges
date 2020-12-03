class Solution {
    //SC: O(n)
    //TC: O(n)
    /*public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        if(list.size() == 0)
            return null;
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode dummyHead = newRoot;
        for(int i = 1; i < list.size(); i++){
            TreeNode node = new TreeNode(list.get(i));
            dummyHead.right = node;
            dummyHead = dummyHead.right;
        }
        return newRoot;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }*/
    
    //SC: O(h) , h is height of tree required for recursive function stack
    //The addresses are removed from the stack when returning. This space is re-used when making a new call from a level closer to the root. So the maximum numbers of memory addresses on the stack at the same time is the tree height for inroder traversal. Hence, TC of inorder traversal is O(h)
    //TC: O(n) since we traverse each node once
    TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(0);
        current = node;
        inorder(root);
        return node.right;
    }
    
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        root.left = null;
        current.right = root;
        current = root;
        inorder(root.right);
    }
}