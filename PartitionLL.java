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

public class PartitionLL{
    
    public Node partition(Node head, int p)
    {
        if(head == null)
        {
            //message
            return head;
        }
        
        Node big = null;
        Node small = null;
        Node temp = head;
        
        while(temp != null)
        {
            Node x = temp;
            temp = temp.next;
            x.next = null;
            if(x.d >= p)
            {
                if(big != null)
                {
                    big.appendToTail(x);   
                }
                else
                {
                    big = x;
                }
            }
            else
            {
                if(small != null)
                {
                    small.appendToTail(x);   
                }
                else
                {
                    small = x;
                }
            }
        }
        
        if(small != null)
        {
            Node t = small;
            
            while( t.next != null)
            {
                t = t.next;
            }
            
            t.next = big;   
            
            return small;
        }
        
        return big;
    }
    
    public static void main(String args[]) {
        
        PartitionLL rd = new PartitionLL();
        
        Node head = new Node(76);
        
        LinkedList ll = new LinkedList();
        
        head.appendToTail(new Node(32));
        head.appendToTail(new Node(23));
        head.appendToTail(new Node(12));
        head.appendToTail(new Node(32));
        head.appendToTail(new Node(10));
        head.appendToTail(new Node(16));
        head.appendToTail(new Node(90));
        
        //System.out.println("Linked list before calling kthToLast");
        //ll.printLL(head);
        head = rd.partition(head,90);
        
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
                System.out.println("Linked list after calling functionality");
                ll.printLL(head);   
            }
        }
    }
}
