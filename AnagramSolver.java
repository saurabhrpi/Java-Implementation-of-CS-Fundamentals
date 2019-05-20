import java.util.*;
import java.lang.*;

class HashMapList<T,E>
{
    HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
    
    public void put(T key, E value)
    {
        if(!map.containsKey(key))
        {
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(value);
    }
    
    public Set<T> getKeySet()
    {
        return map.keySet();
    }
    
    public ArrayList<E> get(T key)
    {
        return map.get(key);
    }
}

class Anagrams implements Comparator<String>{
    
    public String sortArrays(String s)
    {
        if(s == null)
        {
            return null;
        }
        
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public int compare(String s1, String s2)
    {
        return (sortArrays(s1)).compareTo(s2);
    }
}

public class GroupAnagrams{
    
    public String[] group(String[] inp)
    {
        HashMapList<String, String> ht = new HashMapList<String, String>();
        
        for(String s : inp)
        {
            String key = s; // Thankfully didn't declare it as StringBuilder otherwise would have ended up modifying s itself.
            char[] ch = key.toCharArray();
            Arrays.sort(ch);
            ht.put(new String(ch), s);
        }
        
        String[] res = new String[inp.length];
        int index = 0;
        for(String key : ht.getKeySet())
        {
            for(String i : ht.get(key))
            {
                res[index] = i;
                index++;
            }
        }
        
        return res;
    }

    public static void main(String[] args)
    {
        String[] arr = {
        "bc",
        "de",
        "ef",
        "cb",
        "df",
        "fe",
        "gh",
        "ed"
        };
        
        //AnagramSolver as = new AnagramSolver();
        AnagramSolverHM as = new AnagramSolverHM();
        
        String[] res = as.solve(arr);
        
        for(int i=0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
}
