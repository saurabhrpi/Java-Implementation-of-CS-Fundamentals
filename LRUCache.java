import java.util.*;
import java.lang.*;

class DLinkedNode{
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}

public class LRUCache{
    HashMap<Integer, DLinkedNode> cache;
    int capacity;
    int count;
    DLinkedNode head = null;
    DLinkedNode tail = null;
    
    LRUCache(int capacity)
    {
        this.capacity = capacity;
        cache = new HashMap<Integer, DLinkedNode>();
        count = 0;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        tail.post = null;
        head.pre = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    private void addNode(DLinkedNode node)
    {
        node.post = head.post;
        node.pre = head;
        
        head.post.pre = node; 
        head.post = node;
        
        count++;
    }
    
    private void removeNode(DLinkedNode node)
    {
        try
        {
            node.pre.post = node.post;
            node.post.pre = node.pre;
            
            node.pre = null;
            node.post = null;
            
            --count;
        }
        catch(NullPointerException e)
        {
            System.out.println("No removeable node found ");
        }
    }
    
    public int get(int key)
    {
        DLinkedNode node = cache.get(key);
        
        if(node == null)
        {
            return -1;
        }
        
        //move to head
        removeNode(node);
        addNode(node);
        
        return node.value;
    }
    
    public void set(int key, int value)
    {
        DLinkedNode node = cache.get(key);
        
        if(node == null)
        {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            
            cache.put(key, node);
            addNode(node);
            
            if(count > capacity)
            {
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        }
        else
        {
            node.key = key;
            node.value = value;
        }
    }
    
    public static void main(String[] args)
    {
        LRUCache lcache = new LRUCache( 2 /* capacity */ );
        
        lcache.set(1, 1);
        lcache.set(2, 2);
        
        System.out.println("lcache.get(1) " + lcache.get(1));       // returns 1
        lcache.set(3, 3);    // evicts key 2
        System.out.println("lcache.get(2) " +lcache.get(2));       // returns -1 (not found)
        lcache.set(4, 4);    // evicts key 1
        System.out.println("lcache.get(1) " +lcache.get(1));       // returns -1 (not found)
        System.out.println("lcache.get(3) " +lcache.get(3));       // returns 3
        System.out.println("lcache.get(4) " +lcache.get(4));       // returns 4
    }
}
