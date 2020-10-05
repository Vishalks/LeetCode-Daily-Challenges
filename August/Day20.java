//TC: O(n)
//SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = null;
        ListNode head1 = head;
        ListNode head2 = null;
        ListNode q1 = null;
        ListNode q2 = null;
        
        //get midpoint of list
        while(fast != null && fast.next != null){
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse second half and append elements of reversed list after each element of first half
        if(fast == null){//odd number of elements in linked list
            tail.next = null;
            head2 = reverse(slow);
        }
        else{//even number of elements
            tail = slow;
            slow = slow.next;
            tail.next = null;
           head2 =  reverse(slow);
        }
        
        while(head1 != null && head2 != null){
            q1 = head1.next;
            q2 = head2.next;
            head1.next = head2;
            head2.next = q1;
            head2 = q2;
            head1 = q1;
        }
        if(head2 == null && head1 != null)
            head1.next = null;
        return;
    }
    
    public ListNode reverse(ListNode head){
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        while(p != null){
            q = p.next;
            p.next = r;
            r = p;
            p = q;
        }
        return r;
    }
}