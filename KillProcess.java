import java.util.*;
import java.lang.*;

public class KillProcess{
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
    {
        if(kill == 0)
        {
            return pid;
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        int s = pid.size();
        
        for(int i = 0; i < s; i++)
        {
            map.put(pid.get(i), new HashSet<Integer>());
        }
        
        for(int i = 0; i < s; i++)
        {
            if(map.containsKey(ppid.get(i)))
            {
                HashSet<Integer> children = map.get(ppid.get(i));
                children.add(pid.get(i)); //one to one child father mapping
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        traverse(map, result, kill);
        
        return result;
    }
    
    public void traverse(HashMap<Integer, HashSet<Integer>> map, List<Integer> result, int kill)
    {
        result.add(kill);
        
        for(Integer ch : map.get(kill))
        {
            traverse(map, result, ch);
        }
    }
    
    public static void main(String[] args)
    {
        List<Integer> pid = Arrays.asList(1,3,10,5);
        List<Integer> ppid = Arrays.asList(3,0,5,3);
        int kill = 5;
        
        List<Integer> result = (new KillProcess()).killProcess(pid, ppid, kill);
        
        for(int i=0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
    }
}

