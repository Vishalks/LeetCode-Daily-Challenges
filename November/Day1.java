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
//TC: O(n)
class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head != null){
            result <<= 1;//left shift result by 1(has the same effect as result *= 10 for decimal)
            result |= head.val;//OR the result with val at head(has the same effect as result += head.val for decimal)
            head = head.next;//uodate head to point to next
        }
        return result;
    }
}