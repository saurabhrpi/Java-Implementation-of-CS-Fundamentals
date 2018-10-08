import java.io.*;
import java.lang.RuntimeException;

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

public class StackMin{
    
    Node top;
    
    public Node min()
    {
        return top;
    }
    
    public void push(Node n) 
    {
        Node val = null;
        
        if(top != null)
        {
            if(n.d > top.d)
            {
                val = pop();
                n.next = top;
                val.next = n;
                top = val;
            }
            else
            {
                n.next = top;
                top = n;   
            }
        }
        else
        {
              top = n;
        }
    }
    
    public Node pop() throws RuntimeException
    {
        if(top == null)
        {
            //message
            return null;
        }
        
        Node temp = top;
        top = top.next;
        temp.next = null;
        
        return temp;
    }
    
    
    public void printStack()
    {
        Node temp = top;
        while(temp != null)
        {
            System.out.println(temp.d);
            temp = temp.next;
        }
    }
    
    public static void main(String args[]) {
        
    StackMin m = new StackMin();
    
    m.push(new Node(80));
    m.push(new Node(380));
    m.push(new Node(180));
    m.push(new Node(280));
    
    m.printStack();
    
    System.out.println("min: " + m.min().d);
    }
}
