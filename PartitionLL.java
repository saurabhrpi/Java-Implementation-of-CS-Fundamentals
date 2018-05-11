    /*
    To partition a linked list around a value x, such that all nodes less than x come
    before all nodes greater than or equal to x. If x is contained within the list the values of x only need
    to be after the elements less than x. The partition element x can appear anywhere in the
    "right partition"; it does not need to appear between the left and right partitions
    */

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
    
    public void partition(Node node, int val)
    {
      Node beforeStart = null;
      Node beforeEnd = null;
      Node afterStart = null;
      Node afterEnd = null;  
        
     /* 
        Partition the list
     */  
     while(node != null)
     {
         Node next = node.next;
         node.next = null;
         if(node.data < x)
         {
             /* Insert node into end of before list */
             if(beforeStart = null)
             {
                 beforeStart = node;  // initialized here only
                 beforeEnd = beforeStart;
             }
             else
             {
                 beforeEnd.next = node;  // make the current point to incoming
                 beforeEnd = node;       // move to the new one
             }
         }
         else
         {
             /*Insert node into end of the after list*/
             if(afterStart == null)
             {
                 afterStart = node;
                 afterEnd = afterStart;
             }
             else
             {
                 afterEnd.next = node;
                 afterEnd = node;
             }
         }
         node = next;
      } // end of loop
      
      if(beforeStart == Null)
      {
          return afterStart;
      }
      
      /*Merge before list and after list*/
      beforeEnd.next = afterStart;
      return beforeStart;  
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
        
        //PartitionLL p = new PartitionLL();
        n.partition(10);
        
        while(x != null)
        {
            System.out.println(x.data);  // Print the data to debug the issue  
            x = x.next;
        }
    }
    
    /* Alternate implementation of partition method */
    
    public Node partitionAltImp(Node node, int x)
    {
        Node head = node;
        Node tail = node;
        
        while(node != null)
        {
            
        }
    }
}
