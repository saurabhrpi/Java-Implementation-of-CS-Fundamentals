import java.util.*;
import java.lang.*;

class Project{
    private String name;
    private ArrayList<Project> children = new ArrayList<Project>();
    public HashMap<String, Project> childIds = new HashMap<String, Project>();
    private int dependency = 0;
    
    Project(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Project> getChildren()
    {
        return children;
    }
    
    public void addNeighbor(Project n)
    {
        if(n != null)
        {
            children.add(n);
            childIds.put(n.getName(),n);
            n.increaseDependency();
        }
    }
    
    public void decreaseDependency()
    {
        dependency--;
    }
    
    public void increaseDependency()
    {
        dependency++;
    }
    
    public int getDependency()
    {
        return dependency;
    }
    
    public String getName()
    {
        return name;
    }
    
}

class Graph{
    public ArrayList<Project> nodes = new ArrayList<Project>();
    public HashMap<String, Project> projectIDs = new HashMap<String, Project>();
    
    public Project getProject(String name)
    {
        if(!projectIDs.containsKey(name))
        {
            return null;
        }
        
        return projectIDs.get(name);
    }
    
    Graph(String[] nodes, String[][] edges)
    {
        for(int i=0; i < nodes.length; i++)
        {
            Project n = new Project(nodes[i]);
            this.nodes.add(n);
            projectIDs.put(nodes[i], n);
        }
        
        for(int i=0; i < edges.length; i++)
        {
            Project first = getProject(edges[i][0]);
            Project sec = getProject(edges[i][1]);
            first.addNeighbor(sec);
        }
    }
}

public class BuildOrder{
    
    public Project[] createOrderHelp(String[] nodes, String[][] edges)
    {
        Graph g  = new Graph(nodes, edges);
        return createOrder(g);
    }
    
    public int addNonDependentProject(Project[] order, ArrayList<Project> projects, int offset)
    {
        for(int i=0; i < projects.size(); i++)
        {
            if(projects.get(i).getDependency() == 0)
            {
                order[offset++] = projects.get(i);
            }
        }
        return offset;
    }
    
    public Project[] createOrder(Graph g)
    {
        ArrayList<Project> projects = g.nodes; 
        
        Project[] order = new Project[g.nodes.size()];
        
        int end = addNonDependentProject(order, projects, 0);
        
        int toBeProcessed = 0;
        
        while(toBeProcessed != order.length)
        {
            Project current = order[toBeProcessed];
            
            if(current == null)
            {
                return null ; // cycle detected
            }
            
            ArrayList<Project> children = current.getChildren();
            
            for(int i=0; i < children.size(); i++)
            {
                children.get(i).decreaseDependency();
            }
            
            end = addNonDependentProject(order, children, end);
            
            toBeProcessed++;
        }
        
        return order;
    }
    
    public static void main(String[] args)
    {
        String[] projects = {"a","b","c","d","e","f"};
        
        String[][] dep = {
            {"d","a"}, 
            {"f","b"},
            {"b","d"},
            {"f","a"},
            {"d","c"},
        };
        
        BuildOrder bo = new BuildOrder();
        
        Project[] res = bo.createOrderHelp(projects, dep);
        
        System.out.println("The order is ");
        
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i].getName());
        }
    }
}
