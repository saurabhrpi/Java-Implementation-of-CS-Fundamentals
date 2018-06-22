/*
Consider a scenario where two numbers can be represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.
*/

/* My implementation */

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
    
    public Node handler(Node head, Node tail)
    {
        //SingleDigitNumbersSum s = new SingleDigitNumbersSum();
        int sum = num(head);
        sum = sum + num(tail);
        
        //System.out.println(sum);
        Node newHead = create(sum);
        return newHead;
    }
    
    public Node create(int sum)
    {
        Node head = new Node(sum);
        return head;
    }
    
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
        
        Node tail = new Node(7);
        tail.appendToTail(3);
        tail.appendToTail(9);
        
        head = new Node(4);  // test case #2
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(0);
        
        head = new Node(4);  // test case #3
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);
        
        SingleDigitNumbersSum s = new SingleDigitNumbersSum();
        Node x = s.handler(head,tail);
        while(x != null)
        {
            System.out.println(x.data);
            x = x.next;
        }
    }
}

/*End of my impelementation*/

/*Book's Implementation*/

Node addLists(Node l1, Node l2, int carry)
{
    if(l1 == null && l2 == null && value == 0)
    {
        return null;
    }
    
    Node result = new Node();
    int value = carry;
    
    if(l1 != null)
    {
        value += l1.data;
    }
   
    if(l2 != null)
    {
        value += l2.data;
    }
    
    result.data = value % 10; // Second digit of the value
    
    // Recurse
    
    if(l1 != null || l2 != null)
    {
        Node more = addLists(
                        l1 == null ? null : l1.next,
                        l2 == null ? null : l2.next,
                        value > 10 ? 1 : 0
                        );
        result.setNext(more); // add more as result's next node
    }
    return result;
}

// followup

/*End of Book's Implementation*/
