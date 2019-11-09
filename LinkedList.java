class Node{
    int val;
    Node next;
    
    Node(int val)
    {
        this.val = val;
    }
}

class LinkedList{
    
    Node n;
    
    LinkedList(int[] arr)
    {
        n = new Node(arr[0]);
        Node temp = n;
        for(int i = 1; i < arr.length; i++)
        {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
    }
    
    Node getHead()
    {
        return n;
    }
    
    void printLL()
    {
        Node temp = n;
        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
