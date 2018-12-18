import java.util.*;
import java.lang.*;

class LRUCache {
    int capacity = 0;
    HashMap<Integer, LinkedList<Integer>> map;
    
    public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<Integer, Integer>();
            l = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        int res =  map.getOrDefault(key, -1);
        reOrder(key);
        return res;
    }
    
    public void put(int key, int value) {
        if(map.size() == capacity)
        {
            l.removeLast();
        }
        
        l.addFirst(key);
        
        map.put(key, value);        
    }
    
    public void reOrder()
    {
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
