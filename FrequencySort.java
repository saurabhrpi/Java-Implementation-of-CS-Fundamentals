import java.util.*;
import java.lang.*;

public class FrequencySort{
    
    public String sort(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        List<Character>[] bucket = new List[s.length()];  // can't use arrayList as an index could be reinitialized
                                                          // can't use array as the length of the second array is unknown                               
        for(char k : map.keySet())
        {
            int frequency = map.get(k);
            if(bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<Character>();   
            }
            bucket[frequency].add(k);    
        }
        
        StringBuilder sb = new StringBuilder();
        for(int pos = bucket.length - 1; pos >= 0; pos--)
        {
            if(bucket[pos] != null)
            {
                for(char c : bucket[pos])
                {
                    for(int i=0; i < map.get(c); i++)
                    {
                        sb.append(c);   
                    }   
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println((new FrequencySort()).sort("cccaaa"));
    }
}
