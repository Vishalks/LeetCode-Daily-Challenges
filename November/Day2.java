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
//SC: O(1)
//TC: O(n^2)
/*trying to constructed a sorted linked list using nodes from the original list, node by node.
For example:
originally 1->3->2->null
dummy: 0->null;
after the first loop:
original list :3->2->null
dummy:0->1->null
after the second loop:
original list: 2->null
dummy:0->1->3->null
after the third loop:
original list :null
dummy:0->1->2->3-> null*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;//prev always points to last node in the sorted list
        while(head != null){
            ListNode temp = head.next;
            
            //since prev always points to last node in sorted list, then prev.val > head.val means head.val can be inserted somewhere in between the sorted list and not at the end. Hence, move back prev to head of sorted list
            //Eg. dummy->0->2  head->1 prev points to 2 since it's the last node in the sorted list
            if(prev.val > head.val)
                prev = dummy;
            
            //find the position in the sorted list where the new node from unsorted list can be inserted
            while(prev.next != null && prev.next.val < head.val)
                prev = prev.next;
            
            //update next pointer of head and prev to insert the node pointed by head into the sorted list
            head.next = prev.next;
            prev.next = head;
            head = temp;//update head to point to next node in the unsorted list
        }
        return dummy.next;//return head of sorted list
    }
}