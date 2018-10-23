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
                    if(var < (Integer)inp.peek())
                    {
                        System.out.println("var pushed to temp " + var);   
                        temp.push(var);
                        var = (Integer)inp.pop();
                        System.out.println("new value of var " + var);   
                    }
                    else
                    {
                        System.out.println("inp's top pushed into temp " + inp.peek());   
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
                
                if(it != inpS)
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
        
        Stack t = (Stack) s.clone(); 
        
        while (!t.empty())
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
    
    // Book's implementation of Sort
    
    public void bookSort(Stack inp)
    {
        if(inp != null && !inp.empty())
        {
            Stack temp = new Stack();
            while(!inp.empty())
            {
                int var = (Integer)inp.pop();
                while(!temp.empty() && (Integer)temp.peek() > var)
                {
                    inp.push(temp.pop()); // Compare till the right place of var is found in temp
                }
                temp.push(var);
            }
            
            while(!temp.empty())
            {
                inp.push(temp.pop());
            }
            printStack(inp);
        }
    }

    
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(190);
        s.push(910);
        s.push(100);
        s.push(1);
        s.push(10);
        s.push(9);
        s.push(7);
        s.push(1);
        s.push(2);
        
        SortStack ss = new SortStack();
        
        ss.sort(s);
    }
}
