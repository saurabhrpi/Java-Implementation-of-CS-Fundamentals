import java.util.*;
import java.lang.*;

class Node{
    public int data;
    Node below;
    Node above;
    
    Node()
    {
        
    }
    
    Node(int val)
    {
        this.data = val;
    }
}

class myStack extends Stack<Node>{
    int thresh;
    int size;
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
        if(m[m.length - 1].size == m[m.length - 1].thresh)
        {
            m = expand();
        }
        
        
        Node prev = null;
        

        if(m[m.length - 1].size > 0)
        {
            prev = m[m.length - 1].peek();
        }
        
        Node n = new Node(val);
        m[m.length - 1].push(n);
        m[m.length - 1].size++;
        
        if(m[m.length - 1].bottom == null)
        {
            m[m.length - 1].bottom = n;
        }
        
        m[m.length - 1].top = n;
        
        if(prev != null)
        {
            m[m.length - 1].peek().below = prev;
            prev.above = m[m.length - 1].peek();   
        }
        
    }
    
    public Node pop()
    {
        int i = m.length - 1;
        
        while(m[i].empty() && i > 0)
        {
            i--;
        }
        
        Node n = (Node) m[i].pop();
        m[i].size--;
        
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
        //System.out.println("size "+ size(index));
        
        Node res = (Node) m[index].pop();
        m[index].size--;
        
        if(index == m.length - 1)
        {
            return res;
        }    
        
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

    
    public void printSet()
    {
        int i = 0;
        while(i < m.length)
        {
            int k = 0;
            if(m[i] != null)
            {
                Stack c = (Stack)m[i].clone();
                //System.out.println("")
                while(k < m[i].size)
                {
                    System.out.println("This is element #" + (k+1) + " of stack #" + (i+1) + ": "+ ((Node)c.pop()).data);
                    k++;
                }
            }
            i++;   
        }
    }
    
    public static void main(String[] args)
    {
        SetOfStacks ss = new SetOfStacks(3);
        ss.push(89);
        ss.push(189);
        ss.push(829);
        ss.push(893);
        ss.push(899);
        ss.push(809);
        ss.push(119);
        ss.push(11);
        
        ss.printSet();
        
        ss.popAt(2);
        
        ss.printSet();
    }
}

/* Textbook Implementation */
