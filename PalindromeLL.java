import java.io.*;
import java.util.*;

class Node{
    char d;
    Node next;
    
    Node()
    {
        
    }
    
    Node(char i)
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
