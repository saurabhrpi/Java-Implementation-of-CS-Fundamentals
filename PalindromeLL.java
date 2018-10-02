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

class Mid
{
    int m;
    boolean odd;
}

public class PalindromeLL{
    
    public boolean isPalindrome(Node head)
    {
        if(head == null)
        {
            return false;
        }
        
        if(head.next == null)
        {
            return true;
        }
        
        //Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList();
        
        LinkedL ll = new LinkedL();
        
        int l = ll.len(head);
        
        Mid m = new Mid();
        
        if(l%2 == 1)
        {
            m.m = (l+1)/2;
            m.odd = true;
        }
        else
        {
            m.m = l/2;
            m.odd = false;
        }
        
        //System.out.println("mid1 " + mid[1]);
        
        return recurseHandler(head, q, m);
    }
    
    public boolean recurseHandler(Node head, Queue<Integer> q , Mid m)
    {
        if(head == null)
        {
            return true;
        }
        
        if(m.m > 0)
        {
            q.add(head.d);
            //s.push(head.d);
            System.out.println("value pushed to s " + head.d);
            //mid[0]-- ;
        }
        
        if(head.next != null)
        {
            System.out.println("head.next passed " + head.next.d);   
        }
        
        m.m--;
        System.out.println("mid " + m.m);
        
        if(!recurseHandler(head.next, q, m))
        {
            return false;
        }
        
        if(m.m < 0)
        {
            m.m++;
            System.out.println("head.d compared to s 1st " + head.d);
            System.out.println("s compared to d above 1st " + q.peek());
            //return (s.pop() == head.d);
            return (q.remove() == head.d);
        }
        
        if(m.m == 0 && m.odd)
        {
            System.out.println("peeking when m is odd " + q.peek());
            //s.pop();  
            q.remove();
            m.m++;   
        }
        //System.out.println("head.d  " + head.d);
        return true;
    }
    
    public Result booksRecursive(Node head, int l)
    {
        if(head == null || l == 0)
        {
            return new Result(head, true);
        }
        
        if(l == 1)
        {
            return new Result(head.next, true);
        }
        
        Result res = booksRecursive(head.next, l - 2);
        
        
        if(!res.res)
        {
            return res;
        }
        
        
        res.res = (head.d == res.n.d);
        res.n = res.n.next;
        
        return res;
    }
    
    public boolean iterative(Node head)
    {
        if(head == null)
        {
            System.out.println("Empty linked list entered");
            return false;
        }
        
        if(head.next == null)
        {
            System.out.println("Linked list has only one node");
            return true;
        }
        
        LinkedL ll = new LinkedL();
        
        int l = ll.len(head);
        
        boolean ig = false;
        
        int mid = 0;
        
        if(l % 2 == 1)
        {
            mid = (l+1)/2;
            ig = true;
        }
        else
        {
            mid = (l)/2;
        }
        
        int[] c = new int[mid];
        
        Node n = head;
        
        int i = 0;
        while(i < mid && n != null)
        {
            c[i] = n.d;
            i++;
            n = n.next;
        }
        
        if(ig)
        {
            i--;
        }
        
        i--;    
        while(i >= 0 && n != null)
        {
            if(c[i] != n.d)
            {
                return false;
            }
            
            n = n.next;
            i--;
        }
        return true;
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
        head3.appendToTail(new Node(8));
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
    }
}
