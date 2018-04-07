// Implement an algorithm to find the kth to last element of a singly linked list

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

public class ReturnKthToLast{
  public Node returnElement(int k, Node head)
  {
      
    //Node beh = head;
    Node frnt = head;
    Node nullN = null;
    
    for(int i=0; i < k-1 ; i++)
    {
        if(frnt.next != null)
        {
            frnt = frnt.next;   
        }
        else
        {
            return nullN;
        }
    }
    
    while(frnt.next != null)
    {
        head = head.next;
        frnt = frnt.next;
    }
    
    return head;
  }
  
  public int returnIndex(int k, Node head)
  {
      //Using Recursion
      
      if(head == null)
      {
          return 0;
      }
      
      int indexToLast = returnIndex(k,head.next) + 1;
      
      if(k == indexToLast)
      {
          System.out.println(head.data);
      }
      
      return indexToLast;
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
        
        ReturnKthToLast r = new ReturnKthToLast();
        Node x = r.returnElement(2,n);
        System.out.println(x.data);
        
        System.out.println(r.returnIndex(2,n));
    }
}
