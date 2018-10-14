import java.util.*;
import java.lang.*;

class myStack extends Stack{
    
    int thresh;
    
}

public class SetOfStacks{
    
    myStack[] m;
    
    public SetOfStacks(int thresh)
    {
        m = new myStack[1];
        m[0] = new myStack();
        m[0].thresh = thresh;
    }
    
    public myStack[] expand()
    {
        myStack[] n = new myStack[m.length + 1]; 
        
        int i=0;
        
        for(; i < m.length; i++)
        {
            n[i] = (myStack) m[i].clone();
        }
        
        n[i] = new myStack();
        
        return n;
    }
    
    public void push(int val)
    {
        if(size(m.length - 1) == m[m.length - 1].thresh)
        {
            m = expand();
        }
    
        m[m.length - 1].push(val);
    }
    
    public Integer pop()
    {
        int i = m.length - 1;
        
        while(m[i].empty() && i > 0)
        {
            i--;
        }
        
        Integer in = (Integer)m[i].pop();
        
        if(m[i].empty() && i>0)
        {
            myStack[] s = new myStack[i];
            
            i--;
            while(i >= 0)
            {
                s[i] = (myStack)m[i].clone();
                i--;
            }
            
            m = s;
        }    
        
        return in;        
    }
    
    public int size(int stackNum)
    {
        if(m[stackNum] != null)
        {
            Stack s = new Stack();
        
            int count = 0;
            while(!m[stackNum].empty())
            {
                count++;
                s.push(m[stackNum].pop());
            }
            
            while(!s.empty())
            {
                m[stackNum].push(s.pop());
            }   
            
            return count;
        }
        
        return -1;
    }

    
    public void printSet()
    {
        int i = 0;
        while(i < m.length)
        {
            int k = 0;
            if(m[i] != null)
            {
                Stack c = (Stack)m[i].clone();
                while(k < size(i))
                {
                    System.out.println("This is element #" + (k+1) + " of stack #" + (i+1) + ": "+ c.pop());
                    k++;
                }
            }
            i++;   
        }
        
        while(m.length > 0 && !m[0].empty())
        {
            System.out.println("just removed: "+ pop());
        }
    }
    
    // FollowUp
    
    public Integer popAt(int index)
    {
        int subStack = (index / m[0].thresh);
        int off = (index % m[0].thresh) - 1;
        
        Stack s = new Stack();    
        
        while(size(subStack) - index > 0)
        {
            System.out.println("before "+ size(subStack));
            s.push(m[subStack].pop());
            System.out.println("after "+ size(subStack));
        }
        
        Integer res = (Integer)m[subStack].pop();
        
        while(!s.empty())
        {
            m[subStack].push(s.pop());
        }
        
        if(subStack == m.length - 1)
        {
            return res;
        }
        
        int movedFS = subStack + 1;
        int movedTS = subStack;
        
        while(movedFS <= (m.length - 1))
        {
          while(!m[movedFS].empty())    
          {
              s.push(m[movedFS].pop());
          }
          
          while(!s.empty())
          {
            m[movedTS].push(s.pop());    
          }
          
          movedFS++;
          movedTS++;
        }   
        
        return res;
    }
    
    public static void main(String[] args)
    {
        SetOfStacks ss = new SetOfStacks(5);
        ss.push(89);
        ss.push(189);
        ss.push(829);
        ss.push(893);
        ss.push(899);
        ss.push(809);
        ss.push(119);
        ss.push(11);
        
        ss.printSet();
        
        ss.push(89);
        ss.push(189);
        ss.push(829);
        ss.push(893);
        ss.push(899);
        ss.push(809);
        ss.push(119);
        ss.push(11);
        
        ss.printSet();
    }
}
