import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node above, below;
    
    Node()
    {
        
    }
    
    Node(int n)
    {
        data = n;
    }
}

class myStack extends Stack<Node>{
    int thresh;
    int size;
    
    Node top, bottom;
    
    myStack()
    {
        
    }
    
    myStack(int thresh)
    {
        this.thresh = thresh;
        //super();
    }
}

public class SetOfStacks{
    myStack[] m;
    
    SetOfStacks(int thresh)
    {
        m = new myStack[1];
        m[0] = new myStack(thresh);
    }
    
    public void push(Node n)
    {
        if(m[m.length-1].size == m[m.length-1].thresh)
        {
            m = expand();
        }
        
        Node prev = null;
        
        if(m[m.length - 1].size > 0)
        {
            prev = m[m.length - 1].peek();
        }
            
        m[m.length-1].push(n);
        m[m.length-1].size++;
    
        
        if(m[m.length - 1].bottom == null)
        {
            m[m.length - 1].bottom = n;
        }
        
        m[m.length - 1].top = n;
        
        if(prev != null)
        {
            prev.above = n;
            n.below = prev;
        }

    }
    
    public Node pop()
    {
        if(m[m.length - 1].size == 0)
        {
            return null;
        }
        
        Node res = (Node)m[m.length - 1].pop();
        m[m.length - 1].top = res.below;
        res.below.above = null;
        res.below = null;
        m[m.length - 1].size--;
        
        
        if(m[m.length - 1].empty())
        {
            myStack[] n = new myStack[m.length - 1];
            
            for(int i = 0; i < m.length - 1; i++)
            {
                n[i] = (myStack)m[i].clone();
            }
            
            m = n;
        }
        
        return res;
    }
    
    public Node popAt(int index)
    {
        Node res = m[index].pop();

        // remove top
        m[index].top = res.below;
        res.below.above = null;
        res.below = null;
        m[m.length - 1].size--;
        
        if(index != m.length - 1)
        {
            int movedFS = index + 1;
            int movedTS = index;
            while(movedFS <= m.length - 1)
            {
                Node n = m[movedFS].bottom;
                m[movedFS].bottom = n.above;
                m[movedFS].bottom.below = null;
                n.above = null;
                m[movedTS].push(n);
                movedFS++;
                movedTS++;
            }
        }
        
        return res;
    }
    
    public myStack[] expand()
    {
        myStack[] n = new myStack[m.length + 1];
        
        int i=0;
        for(; i < m.length; i++)
        {
            myStack s = (myStack)m[i].clone();
            n[i] = s;
        }
        
        n[i] = new myStack(m[0].thresh);
        
        return n;
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
        ss.push(new Node(89));
        ss.push(new Node(189));
        ss.push(new Node(829));
        ss.push(new Node(893));
        ss.push(new Node(899));
        ss.push(new Node(809));
        ss.push(new Node(119));
        ss.push(new Node(11));
        
        ss.printSet();
        
        ss.popAt(0);
        //ss.pop();
        
        System.out.println("****");
        
        ss.printSet();
    }
}
