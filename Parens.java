import java.util.*;
import java.lang.*;
import java.io.*;

public class Parens{
    
    Set<String> generateParens(int remaining)
    {
        Set<String> set = new HashSet<String>();
        if(remaining == 0)
        {
            set.add("");
        }
        else
        {
            Set<String> prev = generateParens(remaining - 1);
            for(String str : prev)
            {
                for(int i = 0; i < str.length(); i++)
                {
                    if(str.charAt(i) == '(')
                    {
                        String s = insertInside(str, i);
                        set.add(s);// automatically removes a dupe
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }
    
    public String insertInside(String str, int li)
    {
        String left = str.substring(0, li);
        String right = str.substring(li);
        return left + "()" + right;
    }
    
    public static void main(String[] args)
    {
        
    }
}   
