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

public class DeleteNodeSpecial{
    public void delete(Node acc)
    { 
	acc.data = acc.next.data;
	acc.next = acc.next.next;               
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
        
        DeleteNodeSpecial r = new DeleteNodeSpecial();
        //Node x = r.returnElement(2,n);
        //System.out.println(x.data);
        
        Node c = n.next.next;
        
        r.delete(c);
        
        Node t = n;
        while(t != null)
        {
            System.out.println(t.data);    
            t = t.next;
        }
        
               
    }
}


