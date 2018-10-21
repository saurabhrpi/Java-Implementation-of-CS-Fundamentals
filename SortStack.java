import java.util.*;
import java.lang.*;

public class SortStack{
    
    public void sort(Stack inp)
    {
        if(inp != null && !inp.empty())
        {
            Stack temp = new Stack();
            int it = 0;
            int inpS = size(inp);
            int var = (Integer)inp.pop();
            while(it != inpS)
            {
                int i = 1;
                while(i < inpS - it)
                {
                    if((Integer)inp.peek() > var)
                    {                        
                        temp.push(var);
                        var =  (Integer)inp.pop();                     
                    }
                    else
                    {                        
                        temp.push(inp.pop());   
                    }
                    i++;
                }                
             
                inp.push(var);
                it++;
                
                while(!temp.empty())
                {
                    inp.push(temp.pop());
                }
                
                if( it < inpS )
                {
                    var = (Integer)inp.pop();   
                }
            }
            printStack(inp);
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
        s.push(10);
        s.push(11);
        s.push(11);
        s.push(10);
        //s.push(1);
        //s.push(2);
        
        SortStack ss = new SortStack();
        
        ss.sort(s);
    }
}
