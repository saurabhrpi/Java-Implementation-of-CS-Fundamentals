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
    
    void deleteNode(Node head, Node del)
    {
        if(head != null)
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
    }
}


public class RemoveDupes{
    
    public void remDupInPlace(Node head)
    {
        if(head != null)
        {
            Node prev = head;
            Node next = head;
            while (prev != null)
            {
                next = prev.next;
                while(next != null)
                {
                    if(next.d == prev.d)
                    {
                        System.out.println("Dup found is: " + next.d);
                        LinkedList ll = new LinkedList();
                        ll.deleteNode(head,next);
                    }
                    next = next.next;
                }
                prev = prev.next;
            }
        }
    }
    
    public void remDupWithBuffer(Node head)
    {
        if(head != null)
        {
            Node next = head;
            
            HashSet<Integer> h = new HashSet<Integer>();
            
            LinkedList ll = new LinkedList();
            
            while(next != null)
            {
                if(!h.add(next.d))
                {
                    System.out.println("Dup found is: " + next.d);
                    ll.deleteNode(head,next);
                }
                next = next.next;
            }
        }    
    }
    
    public static void main(String args[]) {
        
        RemoveDupes rd = new RemoveDupes();
        
        Node head = new Node(76);
        
        LinkedList ll = new LinkedList();
        
        head.appendToTail(new Node(28));
        head.appendToTail(new Node(23));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(76));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(11));
        head.appendToTail(new Node(76));
        
        rd.remDupInPlace(head);
        //rd.remDupWithBuffer(head);
        
        //head = ll.mergeSort(head);
            ll.printLL(head);
    }
}
