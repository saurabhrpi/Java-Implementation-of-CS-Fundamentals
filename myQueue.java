import java.util.*;
import java.lang.*;

public class myQueue{
    Stack prim;
    Stack sec;
    
    myQueue()
    {
        prim = new Stack();
        sec = new Stack();
    }
    
    public void add(int val)
    {
        prim.push(val);
    }
    
    public void shiftStacks()
    {
        if(sec.empty())
        {
            while(!prim.empty())
            {
                sec.push(prim.pop());   
            }   
        }
    }
    
    public int peek()
    {
        shiftStacks();
        
        return (int)sec.peek();
    }
    
    public int remove()
    {
        shiftStacks();
        int res = (int)sec.pop();
        
        return res;
    }
    
    public static void main(String[] args)
    {
        myQueue q = new myQueue();
        
        q.add(100);
        
        int res = q.peek();
        System.out.println(res);
        
        q.remove();
        q.add(10);
        res = q.peek();
        System.out.println(res);
        
        q.remove();
        q.add(21);
        res = q.peek();
        System.out.println(res);
    }
}
