import java.util.*;
import java.lang.*;
import java.lang.Object;
import java.io.*;

public class PermutationWOD{
    
    ArrayList<String> printPerms(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }
    
    HashMap<Character, Integer> buildFreqTable(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
        {
            if(!map.containsKey(c)) 
                map.put(c,1); 
            else
                map.put(c, map.get(c) + 1);
        }
        return map;
    }
    
    void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result)
    {
        if(remaining == 0) 
        {
            result.add(prefix);
            return;
        }
        
        for(Character c : map.keySet()) //for each character
        {
            int count = map.get(c);
            if(count > 0)
            {
                map.put(c, count - 1);//update map
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count); //re-update for the previous call
            }
        }
    }
    
    public static void main(String[] args)
    {
        PermutationWOD p = new PermutationWOD();
        ArrayList<String> res = p.printPerms("aabc");
        System.out.println(res);
    }
}
