import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node below;
    Node above;
}

class myStack extends Stack<Node>{
    
    Node bottom, top;   
    
    myStack()
    {
        
    }
    
    myStack(int thresh)
    {
        this.thresh = thresh;
    }
}

public class SetOfStacks{
    
    myStack[] m;
    
    public SetOfStacks(int thresh)
    {
        m = new myStack[1];
        m[0] = new myStack(thresh);
    }
    
    public myStack[] expand()
    {
        myStack[] n = new myStack[m.length + 1]; 
        
        int i=0;
        
        for(; i < m.length; i++)
        {
            n[i] = (myStack) m[i].clone();
        }
        
        n[i] = new myStack(m[0].thresh);
        
        return n;
    }
    
    public void push(int val)
    {
        if(size(m.length - 1) == m[m.length - 1].thresh)
        {
            m = expand();
        }
        
        
        Node prev = null;
        
        if(size(m.length - 1) > 0)
        {
            prev = m[m.length - 1].peek();
        }
        
        Node n = new Node(val);
        m[m.length - 1].push(n);
        
        if(bottom == null)
        {
            m[m.length - 1].bottom = n;
        }
        
        m[m.length - 1].top = n;
        
        m[m.length - 1].peek().below = prev;
        prev.above = m[m.length - 1].peek();
        
    }
    
    public Node pop()
    {
        int i = m.length - 1;
        
        while(m[i].empty() && i > 0)
        {
            i--;
        }
        
        Node n = (Node) m[i].pop();
        
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
        
        return n;        
    }
    
    public Node popAt(int index)
    {
        System.out.println("size "+ size(index));
        
        Node res = (Node) m[index].pop();
        
        if(index == m.length - 1)
        {
            return res;
        }
        
        System.out.println("subset != m.length-1");
        
        int movedFS = index + 1;
        int movedTS = index;
        
        while(movedFS <= (m.length - 1))
        {
              
          Node n = m[movedFS].bottom;
          m[movedFS].bottom = n.above;
          n.above.below = null;
          n.above = null;
          m[movedTS].top.above = n;
          n.below = m[movedTS].top;
          m[movedTS].top = n;
          movedFS++;
          movedTS++;
        }   
        
        return res;
    }
    
    public int size(int stackNum)
    {
        if(m[stackNum] != null)
        {
            Stack s = new Stack();
        
            int count = 0;
            while(!m[stackNum].empty())
            {
               // System.out.println("m is not empty" + m[stackNum].peek());
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
        
        ss.popAt(4);
        
        ss.printSet();
    }
}

/* Textbook Implementation */
