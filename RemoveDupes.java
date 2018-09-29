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
        Node temp = this;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = n;
    }
}

class myLinkedList{
    
    public Node appendToHead(Node head, Node n)
    {
        if(n == null)
        {
            //message
            return n;
        }
        
        Node temp = head;
        head = n;
        head.next = temp;
        temp = null;
        
        return head;
    }
    
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
        return head;
    }
}


public class RemoveDupes{
    
    // return type has to be Node and not void as the head itself can change
    public Node remDupInPlace(Node head)
    {
        if(head == null)
        {
            return null;
        }
        
        if(head.next == null)
        {
            return head;
        }
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
        return head;
    }
    
    public Node remDupWithBuffer(Node head)
    {
        if(head == null)
        {
            return null;
        }
        
        if(head.next == null)
        {
            return head;
        }
            
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
        return head;   
    }
    
    public static void main(String args[]) {
        
        RemoveDupes rd = new RemoveDupes();
        
        Node head = new Node(76);
        
        myLinkedList ll = new myLinkedList();
        
        head.appendToTail(new Node(28));
        head.appendToTail(new Node(23));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(76));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(11));
        head.appendToTail(new Node(76));
        
        head = rd.remDupInPlace(head);
        //head = rd.remDupWithBuffer(head);
        
        //head = ll.mergeSort(head);
            ll.printLL(head);
    }
}
