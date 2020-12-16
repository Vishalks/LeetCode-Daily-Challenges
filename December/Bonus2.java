//SC: O(1)
//TC: O(n)
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode notNine = dummyHead;
        
        // find the rightmost not-nine digit
        while(head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }
        
        // increase this rightmost not-nine digit by 1
        notNine.val++;
        notNine = notNine.next;
        
        // set all the following nines to zeros
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        return dummyHead.val != 0 ? dummyHead : dummyHead.next;
    }
}