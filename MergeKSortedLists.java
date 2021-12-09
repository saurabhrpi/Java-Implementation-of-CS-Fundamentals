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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];       
    // ****** Discussed Solution ******     
    return mergeLists(lists,0, lists.length - 1);    
    }            
    
    // ****** Discussed Solution ******. 
    // O(N*k) or O(N*k*log(N)) where N is the number of lists and k is the avg length of each list.
    public ListNode mergeLists(ListNode[] lists, int left, int right)
    {
        if(left > right)
            return null;
        if(left == right)
            return lists[right];
        
        int mid = (left + right)/2;
        ListNode lH = mergeLists(lists, left, mid);
        ListNode rH = mergeLists(lists, mid + 1, right);
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(lH != null && rH != null)
        {
            if(lH.val < rH.val)
            {
                curr.next = lH;
                lH = lH.next;
            }
            else
            {
                curr.next = rH;
                rH = rH.next;
            }
            curr = curr.next;
        }
        curr.next = (lH != null?lH : rH);
        return head.next;
    }
}
/*
         // ************ My Impl ***************
        // O(N*k*log(k)) where k is the avg length of a linked list inside lists 
        // and N is the length of lists.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < lists.length; i++)
        {
            ListNode n = lists[i];
            while(n != null)
            {
                pq.offer(n.val);
                n = n.next;
            }
        }
        ListNode result = null, temp = null;
        while(!pq.isEmpty())
        {
            ListNode n = new ListNode(pq.poll());
            if(result == null)
                result = n;
            if(temp != null)
                temp.next = n;
            temp = n;
        }
        return result;
*/

/* ******* My another Impl. But it takes O(N^2) *********************
        ListNode result = null, tracker = null, prev = null;        
        for(int i = 0; i < lists.length - 1; i++)
        {
            ListNode first = null;
            if(result == null)
                first = lists[0];
            else 
                first = result;            
            result = null; // reset the head.
            prev = null;            
            ListNode sec = lists[i + 1];            
            while(first != null && sec != null)
            {
                if(first.val < sec.val)
                {
                    if(result == null)
                    {                    
                        result = first;                            
                    } 
                    tracker = first;                    
                    if(prev != null)
                    {                        
                        //System.out.println("at line 56 : linking " + prev.val + " to " + tracker.val);
                        prev.next = tracker;   
                    }                        
                    first = first.next;
                }                   
                else
                {                 
                    if(result == null)
                        result = sec;
                    tracker = sec;  
                    if(prev != null)
                    {
                        //System.out.println("at line 68 : linking " + prev.val + " to " + tracker.val);
                        prev.next = tracker;
                    }                        
                    sec = sec.next;                    
                }              
                prev = tracker;   
                //System.out.println("prev now points to " + prev.val);
            }        
            tracker = (first == null? sec : first);            
            while(tracker != null)
            {           
                if(prev != null)
                {
                    //System.out.println("at line 81 : linking " + prev.val + " to " + tracker.val);
                    prev.next = tracker;
                }
                if(result == null)
                {
                    result = (prev == null?tracker:prev);   
                }                    
                prev = tracker;                        
                tracker = tracker.next;                
            }                             
        }
        // tracker = result;
        // while(tracker !=null)
        // {            
        //     System.out.println(tracker.val);
        //     tracker = tracker.next;
        // }
        return result;
*/
