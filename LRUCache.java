class Node
{
    int key,val;
    Node prev, next;
    
    Node()
    {
        
    }
    
    Node(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}

class DoubleLL{
    Node head, tail;
    
    DoubleLL()
    {
        head = new Node();
        tail = new Node();
    }
    
    public void moveToHead(Node n)
    {
        remove(n);
        addToHead(n);
    }
    
    public void addToHead(Node n)
    {
        if(head.next != null)
        {
            head.next.prev = n;
            n.prev = head;
            n.next = head.next;   
        }        
        else
        {
            tail.prev = n;
            n.next = tail;
            n.prev = head;
        }
        head.next = n;
    }
    
    public void remove(Node n)
    {
        Node nex = n.next;
        Node pre = n.prev;
        nex.prev = pre;
        pre.next = nex;        
    }
    
    public void removeTail()
    {        
        Node pre = tail.prev;
        pre.prev.next = tail;
        tail.prev = pre.prev;
        pre.next = null;
        pre.prev = null;
    }
    
    public void printLL()
    {
        Node temp = head;
        int i = 0;
        System.out.println("**printing LL**");
        while(temp != null)
        {
            System.out.println("value at " + i + "th index is " + temp.val);
            temp = temp.next;
            i++;
        }
        System.out.println("**LL printed**");
    }
}

class LRUCache {
    
    HashMap<Integer,Node> cache = new HashMap<Integer,Node>();
    DoubleLL order = new DoubleLL();    
    int capacity, size;    
    public LRUCache(int capacity) {
        this.capacity = capacity;        
    }
    
    public int get(int key) {                
        if(cache.containsKey(key))
        {
          order.moveToHead(cache.get(key));
          return cache.get(key).val;   
        }       
        return -1;
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key))
        {
            if(size == capacity)
            {
                //System.out.println("tail.key " + order.tail.prev.key);
                cache.remove(order.tail.prev.key);
                order.removeTail(); 
                size--;
            }           
            Node n = new Node(key, value);
            order.addToHead(n);
            cache.put(key, n);
            size++;
        }
        else
        {
            Node n = cache.get(key);
            n.val = value;
            cache.put(key, n);  
            order.moveToHead(n);
        }        
       // order.printLL();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
