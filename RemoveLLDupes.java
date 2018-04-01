import java.util.*;

public class Node {
    Node next = null;
    int data;

    public Node(int d)
    {
        data = d;
    }
    
    public void appendToTail(int d)
    {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null)
        {
            n = n.next;
        }
        n.next = end;
    }

    public static void main(String[] args)
    {
        //18,10,9,12,10,18
        Node n = new Node(18);
        n.appendToTail(10);
        n.appendToTail(9);
        n.appendToTail(12);
        n.appendToTail(10);
        n.appendToTail(18);
        
        n.removeDupes();
        
        while(n.next != null)
        {
            System.out.println(n.data);   
            n = n.next;
        }
        System.out.println(n.data);   
       
    }
    
    public void removeDupes()
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        Node n = this;
        Node prev = n;
        
        while(n != null)
        {
            if(hs.contains(n.data))
            {
                prev.next = n.next;
            }
            else
            {
                hs.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }
}

// In place Implementation
