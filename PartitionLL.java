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
    
    public Node partition(Node head, int val)
    {
        if(head == null)
        {
            return null;
        }
        
        if(head.next == null)
        {
            return head;
        }
        
        Node smallLL = null;
        
        Node bigLL = null;
        
        Node next = head;
        Node temp = head.next;
        while(next != null)
        {
            //System.out.println("next node at the beginning of loop: " + next.d);
            if(next.d < val)
            {
                if(smallLL != null)
                {
                  smallLL.appendToTail(next);   // Make sure the node appended is not pointed to already by something else.
                }
                else
                {
                  smallLL = next;
                }
            }
            else
            {
                if(bigLL != null)
                {
                    bigLL.appendToTail(next);
                }
                else
                {
                  bigLL = next;
                }
            }
            next.next = null;
            next = temp;
            if(temp != null)
            {
                temp = temp.next;   
            }
        }
        
        next = bigLL;
        while(next.next != null)
        {
            next = next.next;
        }
        
        next.next = null; // set last node's pointerr of bigLL to null.
        
        next = smallLL;
        if(smallLL != null)
        {
            while(next.next != null)
            {
                next = next.next;
            }   
            
            next.next = bigLL;
        
            return smallLL;
        }
            
            return bigLL;
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
