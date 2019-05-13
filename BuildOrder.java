import java.util.*;
import java.lang.*;

class Project{
    
    // neighbor and children are same.
    
    ArrayList<Project> children = new ArrayList<Project>();
    HashMap<String, Project> map = new HashMap<String, Project>();
    public enum State {BLANK, PARTIAL, COMPLETE};
    
    private String name;
    private int dependency;
    private State state = State.BLANK; 
    
    public Project(String name)
    {
       this.name = name;  
    }
    
    public State getState()
    {
        return state;
    }
    
    public void setState(State st)
    {
        state = st;
    }
    
    /*
    public int getNumberOfDependencies()
    {
        return dependency;
    }
    
    public void incrementDependency()
    {
        dependency++;
    }
    
    public void decrementDependency()
    {
        dependency--;
    }
    */
    
    public String getName()
    {
        return name;
    }
    
    public void addNeighbor(Project node)
    {
        if(!map.containsKey(node.getName()))
        {
            map.put(node.getName(), node);
            children.add(node);
            //node.incrementDependency();
        }
    }
    
    public ArrayList<Project> getChildren()
    {
        return children;   
    }
}

class Graph{
    ArrayList<Project> nodes = new ArrayList<Project>();
    HashMap<String, Project> map = new HashMap<String, Project>(); // required since we can't check if a project instance already exists
    
    public Project getOrCreateNode(String name)
    {
        if(!map.containsKey(name))
        {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }
    
    public void addEdge(String s, String e)
    {
        Project start = getOrCreateNode(s);
        Project end = getOrCreateNode(e);
        start.addNeighbor(end);
    }
    
    public ArrayList<Project> getNodes()
    {
        return nodes;
    }

}

public class BuildOrder{
     
    public Stack<Project> build(String[] projects, String[][] dependencies)
    {
        if(projects.length == 0)
        {
            return null;
        }
        
        Graph g = buildGraph(projects, dependencies);
        return build(g);
    }
    
    public Graph buildGraph(String[] projects, String[][] dependencies)
    {
        Graph g = new Graph();
        
        for(String project : projects)
        {
            g.getOrCreateNode(project);    
        }
        
        for(String[] dependency : dependencies)
        {
            g.addEdge(dependency[0],dependency[1]);
        }
        
        return g;
    }
    
    public Stack<Project> build(Graph g)
    {
        Stack<Project> result = new Stack<Project>();
        
        for(Project p : g.getNodes())
        {
            if(p.getState() == Project.State.BLANK)
            {
                if(!dfs(p, result))
                {
                    return null;
                }
            }
        }
        return result;
    }

    public boolean dfs(Project p, Stack<Project> result)
    {
        if(p.getState() == Project.State.PARTIAL)
        {
            return false; // cycle
        }
        
        if(p.getState() == Project.State.BLANK) // not for Completes
        {
            p.setState(Project.State.PARTIAL);
            for(Project child : p.getChildren())
            {
                if(!dfs(child, result))
                {
                    return false;
                }
            }
            p.setState(Project.State.COMPLETE);
            result.push(p);
        }
        return true;
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
        
        Stack<Project> res = bo.build(projects, dep);
        
        System.out.println("The order is ");
        
        while(!res.empty())
        {
            System.out.println(res.pop().getName());
        }
    }
}

