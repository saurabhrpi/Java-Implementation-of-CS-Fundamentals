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

class Result
{
    Node node;
    boolean result;
    
    Result(Node head, boolean f)
    {
        node = head;
        result = f;
    }
}

public class PalindromeLL{
    
    public boolean isPalindrome(Node head)
    {
        LinkedL ll = new LinkedL();
        int l = ll.len(head);
        Result p = recurse(head, l);
        return p.result;
    }
    
    public Result recurse(Node head, int len)
    {
        if(head == null || len <= 0)
        {
            System.out.println("inside base 1 head and len : "+ head.d + " "+ len);
            return new Result(head, true);
        }
        
        if(len == 1)
        {
            System.out.println("inside base 2 head and len : "+ head.d + " "+ len);
            return new Result(head.next, true); // skip head node and pass head.next, as it is the exact middle one.
        }
        
        Result res = recurse(head.next, len - 2);
        
        if(!res.result || res.node == null)
        {
            System.out.println("it's false. res.node : "+ res.node.d);
            System.out.println("it's false. res.result : "+ res.result);
            return res;
        }
        
        System.out.println("it can be true. head.d : "+ head.d);
        System.out.println("it can be true. res.node.d : "+ res.node.d);
        res.result = (head.d == res.node.d);
        
        // the next node pointed to by Result's node and returned to parent will be compared to 
        // parent's head which will be pointing to a node that is of same distance from the midpoint
        // as Result's node.
        
        System.out.println("at the end. res.node : "+ res.node.d);
        System.out.println("at the end. res.node.next : "+ res.node.next.d);
        
        res.node = res.node.next; 
        
        return res;
    }
    
    

    // 237, 9891
    public static void main(String args[]) {
        
        PalindromeLL rd = new PalindromeLL();
        
        LinkedL ll = new LinkedL();
        
        
        Node head2 = new Node(4);
        head2.appendToTail(new Node(1));
        head2.appendToTail(new Node(3));
        
        Node head3 = new Node(1);
        head3.appendToTail(new Node(9));
        head3.appendToTail(new Node(8));
        //head3.appendToTail(new Node(8));
        head3.appendToTail(new Node(7));
        head3.appendToTail(new Node(1));
        
        //head = rd.result(head3,head2);
        
        //head =  rd.isPalindrome(head);
        
        if(rd.isPalindrome(head3))
        {
            System.out.println("is a pal");
        }
        else
        {
            System.out.println("is NOT a pal");
        }
        /*
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
        */
    }
}
