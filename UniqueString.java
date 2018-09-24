import java.io.*;
import java.util.*;
import java.util.Arrays; 

public class UniqueString{
    
    //ignores space, assumes 128 ASCII
    
    public boolean isUniqueInPlace(String s)
    {
        if(s == null)
        {
            //message
            return false;
        }
        
        char[] ch = s.toCharArray();
        
        Arrays.sort(ch);
        
        for(int i = 0; i < s.length()-1; i++)
        {
            if(ch[i] == ch[i+1] && ch[i] != ' ')
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String [] args)
    {
        UniqueString s = new UniqueString();
        if(s.isUniqueInPlace(" hi ther"))
        {
            System.out.println("is unique");
        }
        else
        {
            System.out.println("is NOT unique");
        }
    }
    
}
