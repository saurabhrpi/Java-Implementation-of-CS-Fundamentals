import java.lang.*;
import java.util.*;

class Project{
    public String name;
    public ArrayList<Project> children = new ArrayList<Project>(); // children = neighbor = dependency
    public HashMap<String, Project> neighborIds = new HashMap<String, Project>();
    public int dependencies = 0;
    
    Project(String name)
    {
        this.name = name;
    }
    
    public void incrementDependencies()
    {
        dependencies++;
    }
    
    public void decrementDependencies()
    {
        dependencies--;
    }
    
    public void addNeighbor(Project node)
    {
        if(!neighborIds.containsKey(node.name))
        {
            neighborIds.put(node.name, node);
            children.add(node);
            node.incrementDependencies();
        }
    }
    
}

 class Graph{
    
    public ArrayList<Project> nodes = new ArrayList<Project>();
    public HashMap<String, Project> projIds = new HashMap<String, Project>();
    
    Graph(String[] nodes, String[][] dep)
    {
        for(int i=0 ; i < nodes.length; i++)
        {
            Project n = new Project(nodes[i]);
            this.nodes.add(n);    
            projIds.put(nodes[i], n);
        }
        
        for(int i=0; i < dep.length; i++)
        {
            Project par = projIds.get(dep[i][0]);
            Project child = projIds.get(dep[i][1]);
            par.addNeighbor(child);
        }
    }
}


public class BuildOrder{
    
    public Project[] createOrderHelp(String[] nodes, String[][] dep)
    {
        Graph g = new Graph(nodes, dep);
        return createOrder(g);
    }
    
    public Project[] createOrder(Graph g)
    {
        Project[] order = new Project[g.nodes.size()];
        int end = addNonDependents(g.nodes, order, 0);
        
        int toBeProcessed = 0;
        
        while(toBeProcessed != order.length)
        {
            Project current = order[toBeProcessed];
        
            if(current == null)
            {
                return null; // cyclic graph
            }
            
            ArrayList<Project> children = current.children;
            
            for(int i=0; i < children.size(); i++)
            {
                children.get(i).decrementDependencies();
            }
            
            end = addNonDependents(children, order, end);
            toBeProcessed++;
        }
        return order;
    }
    
    public int addNonDependents(ArrayList<Project> projects, Project[] order, int offset)
    {
        for(int i=0; i < projects.size(); i++)
        {
            if(projects.get(i).dependencies == 0)
            {
                order[offset] = projects.get(i);
                offset++;
            }
        }
        return offset;
    }
    
    public static void main(String[] args)
    {
        String[] projects = {"a","b","c","d","e","f"};
        
        String[][] dep = {
            {"a","d"}, 
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
            System.out.println(res[i].name);
        }
    }
}
