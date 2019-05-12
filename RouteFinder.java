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
    
// Pick the given start node. 
// Add adjacent nodes to queue. 
// Process all these nodes and their corresponding adjacent nodes until the end is found.
// Processing adjacent nodes above of the nodes is necessary since that's the only way to move ahead.

enum State{Visited, Visiting, Unvisited};

class Node{
    State state; // if instead i'd used boolean, won't be able to have 3 values.
    String name;
    ArrayList<Node> neighbors;
    
    public Node(String name)
    {
        this.name = name;
        neighbors = new ArrayList<Node>();
    }
    
    public ArrayList<Node> getAdjacentNodes()
    {
        return neighbors;
    }
}

class Graph{
    ArrayList<Node> nodes;
    
    Graph()
    {
        nodes = new ArrayList<Node>();
    }
    
    public ArrayList<Node> getNodes()
    {
        return nodes;
    }

}	
	
public class RouteFinder{
    boolean search(Graph g, Node start, Node end)
    {
        if(start == end)
            return true;
        
        LinkedList<Node> q = new LinkedList<Node>();
        
        for(Node u : g.getNodes())
        {
            u.state = State.Unvisited;
        }
        
        start.state = State.Visiting; // in the queue
        q.add(start);
        Node u;
        while(!q.isEmpty()) // method inherited but never implemented in LinkedList class
        {
            u = q.removeFirst();
            if(u != null)
            {
                for(Node v : u.getAdjacent()) // add adjacent nodes to queue
                {
                    if(v.state == State.Unvisited)
                    {
                        if(v == end)
                        {
                            return true;
                        }
                        else
                        {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
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

