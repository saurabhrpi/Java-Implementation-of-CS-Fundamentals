import java.util.*;
import java.lang.*;
import java.io.*;

public class Parens{
    
    // ** brute force **
    
    Set<String> generateParensN(int remaining)
    {
        Set<String> set = new HashSet<String>();
        if(remaining == 0)
        {
            set.add("");
        }
        else
        {
            Set<String> prev = generateParensN(remaining - 1);
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
    
    // *** Optimal ***
    
    // Post-order traversal
    // In the final strings, a right (and the rest) will get added for the first time after all the lefts have been added. 
    // Followed by moving up one level in the leftMost branch, which will then cause leftmost right to move 1 index left and so on. 
    public void addParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index)
    {
        if(leftRem < 0 || rightRem < leftRem) return;// invalid state
        
        if(leftRem == 0 && rightRem == 0) 
        {
            list.add(String.copyValueOf(str));
        }
        else
        {
            str[index] = '(';
            addParens(list, leftRem - 1, rightRem, str, index + 1);
            
            str[index] = ')';
            addParens(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
    
    ArrayList<String> generateParens(int count)
    {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParens(list, count, count, str, 0);
        return list;
    }
    
    public static void main(String[] args)
    {
        
    }
}   
