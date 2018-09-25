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
        
        int[] ch = new int[128];
        
        for(int i=0 ; i < s1.length(); i++)
        {
            ch[s1.charAt(i)]++;
        }
        
        int foundNeg = 0;
        
        for(int i=0 ; i < s2.length(); i++)
        {
            char c = s2.charAt(i);
            ch[c]--;
        
            if(ch[c] < 0)
            {
                foundNeg++;
            }
        }
        
        int diff = Math.abs(s2.length() - s1.length());
        
        if((diff > 0 && foundNeg >= 1) || (diff == 0 && foundNeg > 2))
        {
            return false;
        }
        
        return true;
    }
    
    public static void main(String [ ] a)
    {
        NumEdits x = new NumEdits();
        String s1 = "pales";
        String s2 = "bales";
        System.out.println(x.suffEditsAway(s1, s2));
    }
}
