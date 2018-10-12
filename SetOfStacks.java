import java.util.*;
import java.lang.*;

class myStack extends Stack{
    
    int thresh = 15;
    
    public int size()
    {
        myStack s = new myStack();
        
        int count = 0;
        while(!empty())
        {
            count++;
            s.push(pop());
        }
        
        while(!s.empty())
        {
            push(s.pop());
        }
        
        return count;
    }

}

public class SetOfStacks{
    
    myStack[] m;
    
    public SetOfStacks(int items)
    {
        int len = 0;
        len = (items / 15) + 1; 
        m = new myStack[len];
    }
    
    public void push(int val)
    {
       int i = m.length - 1;
       while(i >= 0)
       {
            if(m[i] != null)
           {
               if(m[i].size() == 15)
               {
                    if(i > 0)
                   {
                      m[i] = new myStack();   
                   }
                   else if(i == 0)
                   {
                       int k = m.length;
                       myStack[] n = new myStack[k + 1];
                       while(k > 0)
                       {
                           n[k] = (myStack) m[k].clone();
                       }
                       n[k].push(val);
                       break;
                   }   
               }
               else
               {
                    m[i].push(val);
                    break;    
               }
           }   
           else
           {
               m[i] = new myStack();
               m[i].push(val);
               break;
           }
           i-- ;
       }
    }
    
    public void printSet()
    {
        int i = 0;
        while(i < m.length)
        {
            int k = 0;
            while(m[i] != null && k < m[i].size())
            {
                System.out.println("This is element #" + k + " of stack #" + i);
                k++;
            }
            i++;
        }
    }
    
    public static void main(String[] args)
    {
        SetOfStacks ss = new SetOfStacks(100);
        ss.push(89);
        ss.push(189);
        ss.push(829);
        ss.push(893);
        ss.push(1189);
        
        ss.printSet();
    }
}
