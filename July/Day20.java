/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.val == val && head.next == null))
            return null;
        ListNode p = head;
        ListNode q = head;
        
        //this hadles case where first val itself is the val to be removed
        if(p.val == val){
            while(p != null && p.val == val)
                p = p.next;
        }
        //if all values in list are the val to be removed
        if(p == null)
            return null;
        
        ListNode r = p;
        q = p;
        p = p.next;
        
        while(p != null && p.next != null){
            if(p.val == val){
                p = p.next;
                q.next = p;
            }
            else{
                q = p;
                p = p.next;
            }
        }
        
        //to handle the case when last node has val to be removed
        if(p != null && p.val == val)
            q.next = null;
        
        return r;
    }
}