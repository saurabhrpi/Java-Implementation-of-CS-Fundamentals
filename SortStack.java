import java.util.*;
import java.lang.*;

public class SortStack{
    
    public void sort(Stack inp)
    {
        if(inp != null && !inp.empty())
        {
            Stack temp = new Stack();
            int it = 0;
            while(it != size(inp))
            {
                int var = (Integer)inp.pop();
                while(size(temp) != size(inp) - it - 1)
                {
                    if((Integer)inp.peek() > var)
                    {
                        var =  (Integer)inp.peek();
                    }
                    temp.push(inp.pop());
                }
                
                inp.push(var);
                it++;
                
                while(!temp.empty())
                {
                    inp.push(temp.pop());
                }
                
                System.out.println("inp at the end");
                printStack(inp);
            }
        }
    }
    
    public int size(Stack s)
    {
        int count = 0;
        Stack t = (Stack)s.clone();
        while(!t.empty())
        {
            count++;
            t.pop();
        }
        return count;
    }
    
    public void printStack(Stack temp)
    {
        Stack t = new Stack();
        t = (Stack)temp.clone();
        while(!t.empty())
        {
            System.out.println(t.pop());   
        }    
    }
    
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(11);
        s.push(5);
        s.push(7);
        
        SortStack ss = new SortStack();
        
        ss.sort(s);
    }
}
