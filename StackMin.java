import java.util.*;
import java.lang.*;

class minNode{
    int val;
    int min;
    
    public minNode(int val, int min)
    {
        this.min = min;
        this.val = val;
    }
}

public class myStack extends Stack<minNode> {
    
    public void push(int value)
    {
        int newMin = Math.min(value, min());
        super.push(new minNode(value, newMin));
    }
    
    public int min()
    {
        if(empty())
        {
            return Integer.MAX_VALUE;
        }
        
        return peek().min;
    }
    
    public static void main(String [] args)
    {
        myStack m = new myStack();
        
        m.push(1);
        m.push(100);
        m.push(0);
        m.push(10);
        m.push(1000);
        
        System.out.println(m.min());
    }
}

// More efficient implementation
class myStack extends Stack<Integer>{
    
    Stack<Integer> m;
    
    public myStack()
    {
        m = new Stack<Integer>();
    }
    
    public void push(int val)
    {
        int min = val;
        if(!m.empty())
        {
            min = Math.min(m.peek(),val);
        }
        
        m.push(min);
        super.push(val);
    }
    
    public Integer pop()
    {
        m.pop();
        return super.pop();
    }
    
    public Integer min()
    {
        if(!m.empty())
        {
            return m.peek();
        }
        
        return Integer.MAX_VALUE;
    }
}
