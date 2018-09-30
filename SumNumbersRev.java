import java.io.*;
import java.util.*;

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

public class SumNumbersRev{
    
    public Node result(Node first, Node second)
    {
        if(first == null && second == null)
        {
            return null;
        }
        
        if(first == null)
        {
            return second;
        }
        
        if(second == null)
        {
            return first;
        }
        
        Node it = first;
        Node it2 = second;
        
        int prevCarry = 0, nexCarry = 0, sum = 0;
        
        Node res = new Node();
        Node next = res;
        
        while(it != null || it2 != null)
        {
            if(it != null)
            {
                sum = it.d;
                it = it.next;
            }
            
            if(it2 != null)
            {
                sum = sum + it2.d;
                it2 = it2.next;
            }
            
            if(sum + prevCarry >= 10)
            {
                nexCarry = 1;
            }
            
            next.d = (sum + prevCarry)%10 ;
            
            System.out.println("node calculated "+ next.d);  
            System.out.println("prevCarry "+ prevCarry);   
            System.out.println("nextCarry "+ nexCarry);   
            res.appendToTail(new Node());
            next = next.next;
            prevCarry = nexCarry;
            nexCarry = 0;
        }
        
        if(prevCarry == 1)
        {
            next.d = 1;
        }
        else
        {
            next = res;
            while(next.next.next != null)
            {
                next = next.next;
            }
            next.next = null;
        }
        
        return res;
    }
    
    public Node recurseResult(Node first, Node second, int carry)
    {
        Node n = new Node();
        
        if(first == null && sec == null)
        {
            if(c != 0)
            {
                n.d = c;   
                return n;
            }
            
            return null;
        }
        
        if(first != null)
        {
            c += first.d;    
        }
        
        if(sec != null)
        {
            c += sec.d;    
        }
        
        if(c >= 10)
        {
            n.d = c % 10;
            c = 1;
        }
        else
        {
            n.d = c;
            c = 0;
        }
        
        n.appendToTail(recurse(first == null? null : first.next, 
                               sec == null? null : sec.next, 
                               c
                               )
                      );
        
        return n;
    }

    // 237, 9891
    public static void main(String args[]) {
        
        SumNumbersRev rd = new SumNumbersRev();
        
        LinkedList ll = new LinkedList();
        
        Node head = new Node(7);
        head.appendToTail(new Node(3));
        head.appendToTail(new Node(2));
        
        Node head2 = new Node(4);
        head2.appendToTail(new Node(1));
        head2.appendToTail(new Node(3));
        
        Node head3 = new Node(1);
        head3.appendToTail(new Node(9));
        head3.appendToTail(new Node(8));
        head3.appendToTail(new Node(9));
        head3.appendToTail(new Node(7));
        
        //head = rd.result(head3,head2);
        
        head =  rd.recurseResult(head, head3, 0);
        
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
