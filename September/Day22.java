//SC: O(1)
//TC: O(n)
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            head = node;
            head.next = head;
            return head;
        }
        Node head1 = head;
        while(true){
            if((insertVal >= head1.val && insertVal <= head1.next.val)//normal ascending order, we found space between 2 nodes to insert new node
              || (head1.next == head)//in case there's only 1 node originally, or we reach back to original head after traversing
              || (head1.val > head1.next.val && (insertVal >= head1.val || insertVal <= head1.next.val)))//since it's a circular linked list, we might get a place between largest and smallest node to insert the new node
            {
                node.next = head1.next;
                head1.next = node;
                break;
            }
            head1 = head1.next;//mode head1 ahead
        }
        return head;
    }
}