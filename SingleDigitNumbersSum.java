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
    public int sum(Node head)
    {
        if(head != null)
        {
            Node temp = head;
            int sum = 0;
            int pow = 0;
            while(temp != null)
            {
                sum = sum + (temp.data)*(10^pow);
                pow++;
                temp = temp.next;
            }
        }
        else
        {
                return null;
        }
        return sum;
    }
}
