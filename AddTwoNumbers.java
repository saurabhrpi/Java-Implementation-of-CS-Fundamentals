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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;        
        /*
        int len1 = calculateLengths(l1);
        int len2 = calculateLengths(l2);
        if(len1 < len2)
        {
            l1 = padZeros(l1, len2 - len1);
        }
        else if(len1 > len2)
        {
            l2 = padZeros(l2, len1 - len2);
        }        
        */
        ListNode res = new ListNode(-1);
        ListNode tracker = res;
        int carry = 0;        
        while(l1 != null || l2 != null)
        {             
          ListNode temp = new ListNode();
          int sum = 0;
          if(l1 != null)
          {
              sum = l1.val;
              l1 = l1.next;
          }              
          if(l2 != null)
          {
              sum += l2.val;     
              l2 = l2.next;
          }              
          sum += carry; 
          if(sum > 9)
          {
            sum = sum % 10;
            carry = 1;   
          }
          else
          {
            carry = 0;   
          }          
          temp.val = sum;
          if(res.val == -1)
              res.val = temp.val;
          else
          {
              tracker.next = temp;
              tracker = temp;   
          }         
        }
        if(carry == 1)
        {
            ListNode last = new ListNode(1);
            tracker.next = last;
        }            
        return res;
    }
    
    public ListNode padZeros(ListNode l, int count)
    {
        
        ListNode temp = l;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        while(count > 0)
        {
            ListNode zero = new ListNode(0);
            temp.next = zero;
            temp = zero;
            count--;
        }        
        return l;
    }
    
    public int calculateLengths(ListNode l)
    {
        ListNode temp = l;
        int i = 0;
        while(temp != null)
        {
            i++;
            temp = temp.next;
        }
        return i;
    }
}
