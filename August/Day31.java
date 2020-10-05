//TC: O(logn) = O(h) where h is height of tree
//SC: O(1)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null && cur.val != key) {
            parent = cur;
            if (key < cur.val) {
                cur = cur.left;
            }
            else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (parent == null) {//node to be deleted is root
            return deleteRootNode(cur);
        }
        if (parent.left == cur) {
            parent.left = deleteRootNode(cur);
        } else {
            parent.right = deleteRootNode(cur);
        }
        return root;
    }
    
    public static TreeNode deleteRootNode(TreeNode root){
        if (root == null) {//node to be deleted is null
            return null;
        }
        if (root.left == null) {//node to be deleted is leaf so return entire right subtree of this root
            return root.right;
        }
        if (root.right == null) {//node to be deleted is leaf so return entire left subtree of this root
            return root.left;
        }
        
        //else node to be deleted is somewhere in the midst of tree
        TreeNode next = root.right;
        TreeNode parent = null;
        
        //go to leftmost leaf of the right subtree since the smallest node just greater than node to be deleted will be at leftmost leaf position of right subtree.
        while(next.left != null){
            parent = next;
            next = next.left;
        }
        next.left = root.left;//make the leftmost leaf in the right subtree as the new root after deletion. so next is new root
        
        //if the the new root was not just to the right of old root
        if(root.right != next) {
            //since we made next as the new root, we need to give a new root to its right child. We don't need to do this for its left subtree because it is the leftmost leaf in original tree and hence its left subtrtee will be null. The new root for the right subtree of next will be root of next child in orignal tree since it's greater than next and hence greater than the entire subtree rooted at next.
            parent.left = next.right;
            //changing right pointer of next which is our new root to point to right subtree of old root
            next.right = root.right;
        }
        return next;//return the new root
    }
}