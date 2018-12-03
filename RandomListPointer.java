import java.util.*;
import java.lang.*;

class RandomListNode{
    int data;
    RandomListNode random;
    RandomListNode next;
    
    RandomListNode(int label)
    {
        data = label;
    }
}

public class RandomListPointer{
  
  public RandomListNode copyRandomListNode(RandomListNode head)
  {
      if(head == null)
      {
          return null;
      }
      
      HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
      
      RandomListNode n = head;
      
      while(n != null)
      {
          map.put(n, new RandomListNode(n.data));
          n = n.next;
      }
      
      n = head;
      while(n != null)
      {
          map.get(n).next = map.get(n.next); // get the object and assign it to next
          map.get(n).random = map.get(n.random);
          n = n.next;
      }
      
      return map.get(head);
  }
  
  public static void main(String args[]) {
       RandomListNode n = new RandomListNode(56);
       RandomListNode k = new RandomListNode(65);
       RandomListNode x = new RandomListNode(161);
       
       n.next = k;
       n.random = x;
       
       k.next = x;
       k.random = n;
       
       x.next = null;
       x.random = k;
       
       RandomListPointer m = new RandomListPointer();
       
       RandomListNode r = m.copyRandomListNode(n);
       
       k.data = 113;
       
       System.out.println(n.next.data);
       System.out.println(r.next.data);
    }
}
