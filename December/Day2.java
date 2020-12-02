//SC: O(1)
//TC: O(n)
class Solution {
    int length = 0;
    Random random;
    ListNode head1, head2;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        head1 = head;
        head2 = head;
        random = new Random();
        while(head != null){
            length++;
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        head2 = head1;
        int i = random.nextInt(length);
        while(true){
            i--;
            if(i < 0){
                return head2.val;
            }
            head2 = head2.next;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */