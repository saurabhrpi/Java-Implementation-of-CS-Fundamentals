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
                int i = 0;
                while(i < inpS - it)
                {
                    //var = (Integer)inp.pop();
                    System.out.println("var popped is " + var);
                    if((Integer)inp.peek() > var)
                    {
                        System.out.println("var pushed into temp " + var);
                        temp.push(var);
                        var =  (Integer)inp.pop();
                        System.out.println("next var popped " + var);
                    }
                    else
                    {
                        System.out.println("next val pushed into temp " + inp.peek());
                        temp.push(inp.pop());   
                    }
                }
                
                inp.push(var);
                it++;
                
                while(!temp.empty())
                {
                    inp.push(temp.pop());
                }
                
                //System.out.println("inp at the end");
                //printStack(inp);
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
