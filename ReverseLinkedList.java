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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
         // ** Given solution.
        // Track each of the 3 nodes - prev, current and next in every iteration.
         ListNode prev = null, curr = head;
         while(curr != null)
         {
             ListNode temp = curr.next;
             curr.next = prev;
             prev = curr;
             curr = temp;
         }
         return prev;        
        
        /* // *** Brute Force. O(N) ***
        ListNode temp = head;
        Stack<Integer> s = new Stack<Integer>();
        while(temp != null)
        {
           s.push(temp.val);
           temp = temp.next;
        }
        
        int v = s.pop();        
        temp = new ListNode(v);         
        ListNode newHead = temp;
        while(!s.isEmpty())
        {
            ListNode n = new ListNode(s.pop());
            temp.next = n;
            temp = n;
        }
        return newHead;
        */
    }
}
