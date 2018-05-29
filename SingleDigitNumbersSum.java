/*
Consider a scenario where two numbers can be represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.
*/

import java.util.*;

class Node {
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
}

public class SingleDigitNumbersSum{
    public int num(Node head)
    {
        int num = 0;
        if(head != null)
        {
            Node temp = head;
            int pow = 0;
            while(temp != null)
            {
                num = num + (temp.data)*((int)Math.pow(10,pow));
                pow++;
                temp = temp.next;
            }
        }
        else
        {
                return 0;
        }
        return num;
    }
    
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.appendToTail(5);
        head.appendToTail(4);
        
        SingleDigitNumbersSum s = new SingleDigitNumbersSum();
        System.out.println(s.num(head));
    }
}
