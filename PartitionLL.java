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
    
    public void partition(int val)
    {
        Node small = new Node();
        Node big  = new Node();
        Node tail  = small;
        
        
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
                    
                }
               
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

            }
            
            head = head.next;
        }
        
        tail.next = big;
        
        while (head != null)
        {
            if(small != null)
            {
                head.data = small.data;
                small = small.next;
                head = head.next;
            }
        }
        return head;
    }
}

public class PartitionLL{    
    
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
        
        //PartitionLL p = new PartitionLL();
        n.partition(10);
        
        while(x != null)
        {
            System.out.println(x.data);  // Print the data to debug the issue  
            x = x.next;
        }
    }
}
