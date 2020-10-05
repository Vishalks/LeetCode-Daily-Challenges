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
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        root.val = 0;
        index(root);
        int max = 0, min = 0, result = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        //BFS
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(i == 0)
                    min = node.val;//at each level of tree, get min index which is first node's index in the queue
                if(i == size-1)
                    max = node.val;//at each level of tree, get max index which is last node's index in the queue
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(result < max-min+1)//if current depth is greater than earlier, result = current depth 
                result = max-min+1;
        }
        return result;
    }
    
    //give indexes to each of the nodes. if parent has index i,
    //index of left child = 2*i, index of right child = 2*i + 1
    public void index(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            root.left.val = 2*root.val;
        if(root.right != null)
            root.right.val = 2*root.val + 1;
        index(root.left);
        index(root.right);
    }
}