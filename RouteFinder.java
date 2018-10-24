import java.util.*;
import java.lang.*;

class Node{
    public String name;
    public ArrayList<Node> children;
    public boolean marked;
    
    Node(String name)
    {
        this.name = name;
        children = new ArrayList<Node>();
    }
}

class Graph{
    public ArrayList<Node> nodes;
    
    Graph()
    {
        nodes = new ArrayList<Node>();
    }

}

public class RouteFinder{
    
    public boolean olderFindRoute(Graph g, Node first, Node sec)
    {
        if(g == null)
        {
            //message
            return false;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        
        first.marked = true;
        
        q.add(first);
        
        while(q.peek() != null)
        {
            Node temp = q.poll();
            
            System.out.println("visiting " + temp.name);
            //System.out.println("sec " + sec);
            if(temp == sec)
            {
                return true;
            }
            
            int i = 0;
            
            while(i < temp.children.size())
            {
                if(!temp.children.get(i).marked)
                {
                    temp.children.get(i).marked = true;
                    q.add(temp.children.get(i));   
                }
                i++;
            }
        }
        
        return false;
    }
    
    // book's implementation
    
    public boolean findRoute(Graph g, Node start, Node end)
    {
        if(g == null)
        {
            return false;
        }
        
        if(start == end)
        {
            return true;
        }
        
        Queue q = new LinkedList<Node>();
        
        start.state = State.VISITING;
        q.add(start);
        
        while(q.peek() != null)
        {
            Node temp = (Node)q.poll();
            
            int i = 0;
            while(i < temp.children.size())
            {
                if(temp.children.get(i).state == State.UNVISITED)
                {
                    if(temp.children.get(i) == end)
                    {
                        return true;
                    }
                    temp.children.get(i).state = State.VISITING;
                    q.add(temp.children.get(i));
                }
                i++;
            }
            temp.state = State.VISITED;
        }
        
        return false;
    }
	
    public static void main(String[] args)
    {
        Node first = new Node("Tom");
        Node sec = new Node("Samantha");
        
        Node n = new Node("Mat");
        
        first.children.add(n);
        first.children.add(new Node("Sam"));
        
        Node j = new Node("Jeff");
        
        n.children.add(j);
        n.children.add(new Node("Ben"));
        Node m = new Node("Martha");
        n.children.add(m);
        
        Node k = new Node("Kate");
        m.children.add(new Node("Mila"));
        m.children.add(k);
        
        k.children.add(sec);
        
        Graph g = new Graph();
        
        g.nodes.add(first);
        g.nodes.add(sec);
        
        RouteFinder rf = new RouteFinder();
        
        if(rf.findRoute(g, first, sec))
        {
            System.out.println("works");
        }
    }
}

