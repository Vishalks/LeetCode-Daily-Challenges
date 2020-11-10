//SC: O(n)
//TC: O(n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        int count1 = 0, count2 = 0;
        //reach till end of both linked list to count number of nodes in each
        while(curr1 != null){
            curr1 = curr1.next;
            count1++;
        }
        while(curr2 != null){
            curr2 = curr2.next;
            count2++;
        }
        
        //Pad smaller list with extra zeroes at the start to make length of both lists same
        while(count1 > count2){
            ListNode node = new ListNode(0);
            node.next = l2;
            l2 = node;
            count2++;
        }
        while(count1 < count2){
             ListNode node = new ListNode(0);
            node.next = l1;
            l1 = node;
            count1++;
        }
        
        //add l1 and l2 recursively. If there is a new node that needs to be created due to carry at the last addition(both MSBs), create a new node
        int carry = add(l1,l2);
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = l1;
            l1 = node;
        }
        return l1;
    }
    
    //add l1 and l2 recursively
    int add(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null)
            return 0;
        
        int carry = add(l1.next, l2.next);
        int temp = l1.val + l2.val + carry;
        l1.val = temp % 10;
        return temp / 10;
    }
}