//SC: O(1)
//TC: O(n)
/*Since n may be a large number compared to the length of list, so we need to know the length of linked list. After that, move the list after the (l-n%l )th node to the front to finish the rotation.
3 steps:
Get the length
Move to the (l - n % l)th node
Do the rotation
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode, slow = dummyNode;
        int len = 0;
        
        //get length of linked list
        while(fast.next != null){
            fast = fast.next;
            len++;
        }
        
        int i = len - (k % len);
        
        //Move to the (l - n % l)th node
        while(i > 0){
            slow = slow.next;
            i--;
        }
        
        //Do the rotation
        fast.next = dummyNode.next;
        dummyNode.next = slow.next;
        slow.next = null;
        
        return dummyNode.next;
    }
}