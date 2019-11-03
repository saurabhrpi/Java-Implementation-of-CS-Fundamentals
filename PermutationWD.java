import java.util.*;
import java.lang.*;
import java.lang.Object;
import java.io.*;

public class PermutationWD{
    
    // Approach #1 (using first n-1 chars)
    
    ArrayList<String> getPerms(String str)
    {
        if(str == null) return null;
        
        ArrayList<String> permutations = new ArrayList<String>(); // need a new instance at every call since all the items of previous list
                                                                //  will need to be modified.
        if(str.length() == 0)
        {
            permutations.add("");
            return permutations;
        }
        
        char first = str.charAt(0);
        String remainder = str.substring(1); // won't throw an exception if length == 1
        ArrayList<String> words = getPerms(remainder);
        for(String word : words)
        {
            for(int i = 0; i <= word.length(); i++) // don't forget the = in "<="
            {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }
        return permutations;
    }
    
    String insertCharAt(String word, char c, int i)
    {
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start + c + end;
    }
    
    // Approach #2 (using all n-1 chars)
    // Diff is here we exclude exactly 1 char at a time. Earlier it could be upto n-1 chars.
    // P(abc) = {a + P(bc)} + {b + P(ac)} + {c + P(ab)}
    
    ArrayList<String> getPerms2(String remainder)
    {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();
        
        if(len == 0)
        {
            result.add("");
            return result;
        }
        
        for(int i = 0; i < len; i++)
        {
            String before = remainder.substring(0,i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms2(before + after);
            
            for(String s : partials)
            {
                result.add(remainder.charAt(i) + s); // Just the first position would do as the other cases will automatically 
                                                          // get covered when the method is called for other characters     
            }
        }
        return result;
    }
    
    // Approach #3 : With ArrayList as argument
    
    ArrayList<String> getPerms3(String str)
    {
        if(str == null) return null;
        
        ArrayList<String> result = new ArrayList<String>();
        getPerms3("", str, result);
        return result;
    }
    
    void getPerms3(String prefix, String remainder, ArrayList<String> result)
    {
        int len = remainder.length();
        
        // a permutation is added only when a prefix has all the chars taken one by one from remainder from prev calls.
        if(len == 0) result.add(prefix);
        
        for(int i = 0; i < len; i++)
        {
            String before = remainder.substring(0,i); // won't return anything if i == 0
            String after = remainder.substring(i+1);
            char c = remainder.charAt(i);
            getPerms3(prefix + c, (before + after), result);
        }
        
    }
    
    public static void main(String[] args)
    {
    
    }
}
