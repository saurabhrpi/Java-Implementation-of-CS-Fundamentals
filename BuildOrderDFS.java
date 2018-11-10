import java.util.*;
import java.lang.*;

enum STATE { BLANK, PARTIAL, VISITED;}

class Project{
    private STATE state = STATE.BLANK;
    private String name;
    private ArrayList<Project> children = new ArrayList<Project>();
    public HashMap<String, Project> childIds = new HashMap<String, Project>();
    private int dependency = 0;
    
    public void setState(STATE state)
    {
        this.state = state;
    }
    
    public STATE getState()
    {
        return state;
    }
    
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
    
    public Stack<Project> createOrderHelpDFS(String[] nodes, String[][] edges)
    {
        Graph g = new Graph(nodes, edges);
        
        ArrayList<Project> projects = g.nodes;
        
        Stack<Project> order = new Stack<Project>();
        
        for(int i=0; i < projects.size(); i++)
        {
            if(!createOrderDFS(projects.get(i), order))
            {
                return null;
            }   
        }
        return order;
    }
    
    public boolean createOrderDFS(Project project, Stack<Project> order)
    {
        if(project == null)
        {
            return true;
        }
        
        if(project.getState() == STATE.PARTIAL)
        {
            return false;
        }
        
        if(project.getState() == STATE.BLANK)
        {
            project.setState(STATE.PARTIAL);
            for(int i=0; i < project.getChildren().size(); i++)
            {
                if(!createOrderDFS(project.getChildren().get(i),order))
                {
                    return false;
                }
            }
            
            project.setState(STATE.VISITED);
            order.push(project);
        }
        return true;
    }
        
    public static void main(String[] args)
    {
        String[] projects = {"a","b","c","d","e","f","g"};
        
        String[][] dep = {
            {"a","b"}, 
            {"b","d"},
            {"f","a"},
            {"b","f"},
            {"d","c"},
            {"b","c"},
            {"e","g"}
        };
        
        BuildOrder bo = new BuildOrder();
        
        //Project[] res = bo.createOrderHelp(projects, dep);
        Stack<Project> res = bo.createOrderHelpDFS(projects, dep);
        
        System.out.println("The order is ");
        
        while(!res.empty())
        {
            System.out.println((res.pop()).getName());
        }
    }
}
