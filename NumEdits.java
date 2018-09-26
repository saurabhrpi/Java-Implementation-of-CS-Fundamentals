import java.io.*;
import java.util.*;
import java.util.LinkedList; 
import java.lang.*;

// assuming ASCII, spaces ignored
public class NumEdits{
    public boolean suffEditsAway(String s1, String s2)
    {
        if(s1 == null || s2 == null)
        {
            //message
            return false;
        }
        
        if(Math.abs(s1.length() - s2.length()) > 1)
        {
            //message
            System.out.println("Diff more than 1");
            return false;
        }
        
        String big = s1.length() >= s2.length() ? s1 : s2;
        String small = s2.length() > s1.length() ? s1 : s2;
        
        System.out.println("big " + big);
        System.out.println("small " + small);
        
        boolean foundDiff = false;
        
        int i;
        int k = 0;
        
        if(small.length() < big.length())
        {
            for(i=0; i < small.length(); i++)
            {
                if(small.charAt(i) != big.charAt(k))
                {
                    if( i == k)
                    {
                        k++;   
                    }
                    else
                    {
                        return false;
                    }
                }
                k++;
            }
        }
        else
        {
            for(i=0; i < small.length(); i++)
            {
                if(small.charAt(i) != big.charAt(i))
                {
                    if(foundDiff)
                    {
                        return false;
                    }
                    foundDiff = true;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String [ ] a)
    {
        NumEdits x = new NumEdits();
        String s1 = "pale";
        String s2 = "lale";
        System.out.println(x.suffEditsAway(s1, s2));
    }
}
