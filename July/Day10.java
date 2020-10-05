/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfs(null, head);
        return head;
    }
    
    public Node dfs(Node perv, Node curr){
        if(curr == null)
            return curr;
        if(perv != null){
            perv.next = curr;
            curr.prev = perv;
        }
        if(curr.child != null){
            Node next = curr.next;
            Node node = dfs(curr, curr.child);
            curr.child = null;
            return dfs(node, next);
        }
        else if(curr.next != null)
            return dfs(curr, curr.next);
        else
            return curr;
    }
}