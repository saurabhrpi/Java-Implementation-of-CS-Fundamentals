import java.util.*;
import java.lang.*;

public class ShortestPalindrome{
    
    public String shortestPalindrome(String s)
    {
        String rev = (new StringBuilder(s)).reverse().toString();
        
        for(int i=0; i < s.length(); i++)
        {
            if(s.indexOf(rev.substring(i)) == 0)
            {
                return rev.substring(0,i) + s;
            }
        }
        
        return rev.substring(0,s.length() - 1) + s;
    }
    
    public static void main(String[] args)
    {
        System.out.println((new ShortestPalindrome()).shortestPalindrome("abcd"));
    }
}
