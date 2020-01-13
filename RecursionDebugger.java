/*
Example of how to print values in a recursive tree-like algorithm
Problem : CTCI 8.8
*/

import java.util.*;
import java.lang.*;

public class Solution {
    
    ArrayList<String> getPerms(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map  = buildFreqTable(s);
        getPerms(map, "", s.length(), result);
        return result;
    }
    
    HashMap<Character, Integer> buildFreqTable(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
        {
            if(!map.containsKey(c))
            {
                map.put(c,1);
            }
            else
            {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
    
    void getPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result)
    {
        if(remaining == 0)
        {
            result.add(prefix);
            return;
        }
        
        for(Character c : map.keySet())
        {
            int count = map.get(c);
            if(count > 0)
            {
                map.put(c, count - 1);
                System.out.println(prefix + " when remaining is " + remaining);
                getPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }
    
    public static void main(String args[]) {
     Solution s = new Solution(); 
     System.out.println(s.getPerms("dabb"));
    }
}
