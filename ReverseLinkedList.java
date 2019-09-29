/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) { 
         if(head == null)
         {
             return null;
         }
              
         ListNode newHead = null;
         while(head != null)
         {
             ListNode next = head.next;
             head.next = newHead; // In first run newHead will be null, so head.next will be null. In subsequent runs, this will make head.next set to the node newHead points to .
             newHead = head;
             head = next;             
         }
        return newHead;
    }
}
