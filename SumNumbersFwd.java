import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node next;
    
    Node()
    {
        
    }
    
    Node(int data)
    {
        this.data = data;
    }
    
    public void appendToTail(Node n)
    {
        Node next = this.next;
        Node prev = this;
        
        while(next != null)
        {
            prev = next;
            next = next.next;
        }
        
        prev.next = n;
    }
    
    
    public void printLL()
    {
        Node temp = this;
        
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class Carry
{
    int car = 0;
}

public class AddNumbers{
    
    public Node addHelper(Node f, Node s)
    {
        Carry car = new Carry();
        
        int diff = findLen(f) - findLen(s);
        
        if(diff != 0)
        {
            if(diff < 0)
            {
                f = padZeroes(f, Math.abs(diff));
            }
            else 
            {
                s = padZeroes(s, diff);
            } 
        }
        
        Node res = add(f, s, car);
        
        if(car.car > 0)
        {
            Node n = new Node(1);
            n.next = res;
            res = n;
        }
        
        return res;
    }
    
    public int findLen(Node head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public Node padZeroes(Node small, int diff)
    {
        while(diff > 0)
        {
            Node n = new Node(0);
            n.next = small;
            small = n;
            diff--;
        }
        
        return small;
    }
    
    public Node add(Node f, Node s, Carry car)
    {
        if(f == null && s == null)
        {
            return null;
        }
        
        Node result = new Node();
        
        result.appendToTail(add(f == null? null : f.next, 
                                s == null? null : s.next, 
                                car)
                            );
        
        if(f != null)
        {
          car.car += f.data;   
        }
        
        if(s != null)
        {
          car.car += s.data;
        }
        
        if(car.car >= 10)
        {
            result.data = car.car % 10;
            car.car = 1;
        }
        else
        {
            result.data = car.car;
            car.car = 0;
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        
        AddNumbers rd = new AddNumbers();
        
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
        
        Node result =  rd.addHelper(head2, head3); //413, 19897
        
        if(head == null)
        {
            System.out.println("Please enter a non null list");
        }
        else
        {
            System.out.println("Linked list after calling functionality");
            result.printLL();   
        }
    }
}
