class Solution {
    public Node connect(Node root) {
               if(root == null)
            return root;
        Node next = null;
        Node rootNext = root.next;
        while(rootNext != null){
            if(rootNext.left != null){
                next = rootNext.left;
                break;
            }
            if(rootNext.right != null){
                next = rootNext.right;
                break;
            }
            rootNext = rootNext.next;
        }
        if(root.right != null)
            root.right.next = next;
        if(root.left != null)
            root.left.next = root.right == null ? next:root.right;
        connect(root.right);
        connect(root.left);
        return root;
    }
        
  
}