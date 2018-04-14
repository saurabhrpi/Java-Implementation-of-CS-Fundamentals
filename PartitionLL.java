class Node {
    Node next = null;
    int data;
    
    public Node()
    {
        
    }
    
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

public class PartitionLL{
    
    public Node partition(Node head, int val)
    {
        Node small = new Node();
        Node big = new Node();
        Node tail = new Node();
        //Node h ;
        
        while(head != null)
        {
            if(head.data < val)
            {
                if(small.next != null)
                {
                    small.appendToTail(head.data);   
                    tail = tail.next;   
                }
                else
                {
                    small.data = head.data;
                    tail = small; 
                    //h = small;
                }
               // System.out.println("tail " + tail.data);
            }
            else
            {
                if(big.next != null)
                {
                    big.appendToTail(head.data);   
                }
                else
                {
                    big.data = head.data;
                }
                //System.out.println("big "+ big.data);
            }
            
            head = head.next;
        }
        
        tail.next = big;
        
        return small;
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
        n.appendToTail(1);  
        
        PartitionLL p = new PartitionLL();
        Node x = p.partition(n, 10);
        
        while(x != null)
        {
            System.out.println(x.data); // Print the data to debug  
            x = x.next;
        }
    }
}
