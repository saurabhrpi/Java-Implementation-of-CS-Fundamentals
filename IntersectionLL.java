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


public class IntersectionLL{
    
    public Node intersecting(Node first, Node second)
    {
        if(!hasIntersection(first, second))
        {
          return null;
        }
        
        LinkedL ll = new LinkedL();
        
        int fl = ll.len(first);
        int sl = ll.len(second);
        int diff = 0;
        Node big = null;
        Node small = null;
        
        if(fl > sl)
        {
            diff = fl - sl;
            big  = first;
            small = second;
        }
        else
        {
            diff = sl - fl;
            big  = second;
            small = first;
        }
        
        int i = 0;
        while(i < diff)
        {
            big = big.next;        
            i++;
        }
        
        Node run1 = big;
        Node run2 = small;
        
        while(run1 != run2)
        {
            run1 = run1.next;
            run2 = run2.next;
        }
        
        return run1;
    }
    
    public boolean hasIntersection(Node first, Node second)
    {
        if(first == null || second == null)
        {
            return true;
        }
        
        while(first != null && first.next != null)
        {
            first = first.next;
        }
        
        while(second != null && second.next != null)
        {
            second = second.next;
        }
        
        return (first == second);
    }
    
    // 237, 9891
    public static void main(String args[]) {
        
        IntersectionLL rd = new IntersectionLL();
        
        LinkedL ll = new LinkedL();
        
        
        Node head = new Node(4);
        Node n = new Node(50);
        head.appendToTail(n);
        head.appendToTail(new Node(3));
        
        Node head2 = n;
        head2.appendToTail(new Node(500));
        //head3.appendToTail(new Node(8));
        head2.appendToTail(new Node(7));
        head2.appendToTail(new Node(6));
        //head2.appendToTail(n);
        
        ll.printLL(head);
        System.out.println("sec below");
        ll.printLL(head2);
        
        Node res = rd.intersecting(head, head2);
        
        if(res == null)
        {
            System.out.println("No Intersection");
        }
        else
        {
            System.out.println("Intersecting node is: " + res.d);
        }
        
    }
}
