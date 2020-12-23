//SC: O(n)
//TC: O(n)
class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList();
        boolean rootFound = false;
        q.add(root);
        
        //bfs
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                //add left and right child to queue
                TreeNode node = q.poll();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                
                //when we visit u
                if(node.val == u.val){
                    //if u is last node in current level, there is no node to its right, return null
                    if(i == size - 1)
                        return null;
                    rootFound = true;//set rootfound flag to true
                }
                else{//when we visit a node other than u
                    if(rootFound == true)//if rootfound flag is set to true, this means current node is the one just to the right of u
                        return node;
                }
            }
        }
        return null;
    }
}