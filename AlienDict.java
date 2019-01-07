import java.util.*;
import java.lang.*;

public class AlienDict{
    
    private final int N = 26;
    
    public String derive(String[] args)
    {
        int[] visited = new int[N];
        boolean[][] adj = new boolean[N][N];
        
        buildGraph(adj, visited, args);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < visited.length; i++)
        {
            if(visited[i] == 0)
            {
                if(!dfs(adj, visited, sb, i))
                {
                    return "";
                }   
            }
        }
        
        return sb.reverse().toString();
    }
    
    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i)
    {
        System.out.println("dfs check for char = " + ((char)(i + 'a')));
        visited[i] = 1; // dfs will run for a char just once 
        for(int j=0; j < N; j++)
        {
            if(adj[i][j])
            {
                if(visited[j] == 1)
                {
                    return false;
                }
                
                if(visited[j] == 0) // for each char there should be no cycle in the entire adj matrix
                {
                    System.out.println("char = " + ((char)(j + 'a')) + " within char = " + ((char)(i + 'a')) + " found to be unvisited");
                    if(!dfs(adj,visited,sb,j))
                    {
                        return false;
                    }
                }
                
            }
        }
        visited[i] = 2;
        System.out.println("appending " + ((char)(i + 'a')));
        sb.append((char)(i + 'a'));
        return true;
    }
    
    public void buildGraph(boolean[][] adj, int[] visited, String[] args)
    {
        Arrays.fill(visited, -1);
        
        for(int i=0; i < args.length - 1; i++)
        {
            for(char c : args[i].toCharArray())
            {
                visited[c - 'a'] = 0;
            }
            String w1 = args[i];
            String w2 = args[i + 1];
            
            int len = Math.min(w1.length(), w2.length());
            
            for(int j=0; j < len; j++)
            {
                if(w1.charAt(j) != w2.charAt(j))
                {
                    adj[w1.charAt(j) - 'a'][w2.charAt(j) - 'a'] = true;
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        String [] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String [] words2 = {"z", "x", "z"};
        String [] words3 = {"z", "x"};
        
        System.out.println((new AlienDict()).derive(words3));
    }
}
