/*
Proof :
non-loop : length of unlooped (linear part of) linked list.
loop : length of looped linked list.
rLoop : residual distance covered by Fast pointer in clockwise direction into the loop the moment slow pointer is at the start node.

If slow pointer covers non-loop distance, then fast covers non-loop + loop + rLoop distance.

This means fast is loop - rloop steps behind slow which it will bridge in loop - rLoop hops.

In the same number of hops the slow (and thus fast) will be at loop - rLoop steps (calculated in clockwise from start of loop).

This is same as rLoop distance in counterclockwise direction from the start of loop. < In progress > 
*/

import java.io.*;
import java.util.*;
import java.util.LinkedList; 
import java.util.Queue; 

class Node{
    int d;
    Node next;
    
    Node()
    {
        
    }
    
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

class LinkedL{
    
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
        
        System.out.println("head returned "+ head.d);
        return head;
    }
    
    int len(Node head)
    {
        int l = 0;
        while(head != null)
        {
            l++;
            head = head.next;
        }
        
        return l;
    }
}


public class LoopDetection{
    
    public Node returnsStartNode(Node head)
    {
        if(head == null || head.next == null)
        {
            // message
            return null;
        }
        
        Node fast = head.next.next;
        Node slow = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;  
            fast = fast.next.next;  
            if(slow == fast && slow != null)
            {
                break;
            }
        }
        
        if(fast == null || fast.next == null)
        {
            return null;
        }
        
        slow = head;
        
        while (fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
    
    
    // 237, 9891
    public static void main(String args[]) {
        
        LoopDetection rd = new LoopDetection();
        
        LinkedL ll = new LinkedL();
        

        Node head = new Node(4);
        head.appendToTail(new Node(50));
        head.appendToTail(new Node(3));
        head.appendToTail(new Node(13));
        head.appendToTail(new Node(103));
        Node n = new Node(30);
        head.appendToTail(n);
        head.appendToTail(new Node(13));
        
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        
        temp.next = null;
        
        Node res = rd.returnsStartNode(head);
        
        if(res == null)
        {
            System.out.println("Not Circular");
        }
        else
        {
            System.out.println("Node is: " + res.d);
        }
        
    }
}

