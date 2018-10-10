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
