import java.util.*;
import java.lang.*;

public class import java.util.*;
import java.lang.*;

public class ValidParentheses{
    
    public boolean validate(char[] arr)
    {
        Stack<Character> s = new Stack<Character>();
        for(char c : arr)
        {
            if(c =='(')
            {
                s.push(')');
            }
            else if(c == '{')
            {
                s.push('}');
            }
            else if(c == '[')
            {
                s.push(']');
            }
            else if(s.isEmpty() || s.pop() != c)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        String s1 = "(]";
        String s2 = "([)]";
        String s3 = "{[]}";
        String s4 = "{}[]()";
        System.out.println((new ValidParentheses()).validate(s4.toCharArray()));
    }
}

{
    
    public boolean validate(char[] arr)
    {
        Stack<Character> s = new Stack<Character>();
        for(char c : arr)
        {
            if(c =='(')
            {
                s.push(')');
            }
            else if(c == '{')
            {
                s.push('}');
            }
            else if(c == '[')
            {
                s.push(']');
            }
            else if(s.isEmpty() || s.pop() != c)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        String s1 = "(]";
        String s2 = "([)]";
        String s3 = "{[]}";
        String s4 = "{}[]()";
        System.out.println((new ValidParentheses()).validate(s4.toCharArray()));
    }
}

