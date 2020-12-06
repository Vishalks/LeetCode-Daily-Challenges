//SC: O(1)
//TC: O(n)
class Solution {
    public Node connect(Node root) {
        Node rootCopy = root;
        Node dummyHead = new Node(0);//dummyHead for a level in tree
        Node current = null;
        while(root != null){
            current = dummyHead;//always set current to dummyHead for a new level of tree
            while(root != null){
                //keep on linking the next pointers of all children of current root
                if(root.left != null){
                    current.next = root.left;
                    current = current.next;
                }
                if(root.right != null){
                    current.next = root.right;
                    current = current.next;
                }
                root = root.next;//move root to next node in the same level
            }
            root = dummyHead.next;//move to next level in tree
            dummyHead.next = null;//maintain tree structure by removing next pointer of dummyHead
        }
        return rootCopy;
    }
}