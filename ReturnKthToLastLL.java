import java.io.*;
import java.util.*;

class Node{
    int d;
    Node next;
    
    Node(int i)
    {
        d = i;
        next = null;
    }
    
    void appendToTail(Node n)
    {
        if(this.next == null)
        {
            this.next = n; 
        }
        else
        {
            Node next = this.next;
            while(next.next != null)
            {
               // System.out.println("next is: " + next.d);
                next = next.next;
            }
            //System.out.println("n is: " + n.d);
            next.next = n;
        }
    }
}

class LinkedList{
    
    void printLL(Node head)
    {
        Node next = head;
        while(next != null)
        {
            System.out.println(next.d);
            next = next.next;
        }
    }
    
    Node deleteNode(Node head, Node del)
    {
        System.out.println("del node requested "+ del.d);   
        if(head == null)
        {
            return null;
        }
        else
        {
            if(del == head)
            {
                head = head.next;
            }
            else
            {
                Node next = head; 
                while(next.next != null)
                {
                    if(next.next == del)
                    {
                        next.next = del.next;
                        break;
                    }
                    next = next.next;
                }
            }
        }
        System.out.println("head returned "+ head.d);
        return head;
    }
}

 class Index { 		/* To be used for Recursive implementation only */
     public int value;
  }


public class RemoveKthToLastLL{
    
    public Node removeKthToLast(Node head, int k) //assuming last node is k=0
    {
        if(head == null || head.next == null)
        {
          return null;
        }
        
        Node runn = head;
        Node prev = head;
        
        int i = 0;
        while(i < k)
        {
            if(runn != null)
            {
                runn = runn.next;
            }
            i++;
        }
        
        while(runn.next != null)
        {
            runn = runn.next;
            prev = prev.next;
        }
        
        LinkedList ll = new LinkedList();
        head = ll.deleteNode(head, prev);
        
        return head;
    }
  
  /* Recursive Implementation : O(n) space - 1 for each call and there will be n calls in the stack. */

  /*Begin*/

  LinkedListNode kthTolast(LinkedlistNode head, int k) 
  {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) 
  {
    if (head == null) // will run when the call goes beyond the last node
    {
       return null;
    }
 
   LinkedListNode node kthToLast(head.next, k, idx); // pass value of idx (by reference)
   idx.value = idx.value + 1; 
    if (idx.value == k) 
    {
       return head; //finally we found the k to the last node. 
                    //This will be passed to all the calls back from here on, all the way out of the recursion.
    }
   return node;  // before i==k we will keep returning the node that was passed to the call.
 }

  /*Ends*/
   
  /* Recursive Implementation*/
	
    
    public static void main(String args[]) {
        
        RemoveKthToLastLL rd = new RemoveKthToLastLL();
        
        Node head = new Node(76);
        
        LinkedList ll = new LinkedList();
        
        head.appendToTail(new Node(28));
        head.appendToTail(new Node(23));
        head.appendToTail(new Node(12));
        head.appendToTail(new Node(32));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(16));
        head.appendToTail(new Node(90));
        
        System.out.println("Linked list before calling kthToLast");
        ll.printLL(head);
        head = rd.removeKthToLast(head,7);
        
        if(head == null)
        {
            System.out.println("Please enter a non null list");
        }
        else
        {
            if(head.next == null)
            {
                System.out.println("There is only one element in the list");
            }
            else
            {
                System.out.println("Linked list after calling kthToLast");
                ll.printLL(head);   
            }
        }
    }
}

