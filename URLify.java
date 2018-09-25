import java.io.*;
import java.util.*;
import java.util.LinkedList; 

// assuming ASCII, spaces ignored
public class URL{
    
    public int countSpaces(char[] ch, int len)
    {
        int count = 0;
        for(int i=0; i<len; i++)
        {
            if(ch[i] == ' ')
            {
                count++;
            }
        }
        return count;
    }
    
    public void makeRoom(char[] ch, int len)
    {       
        int count = countSpaces(ch, len);
        int mark = len + 2*count;
        for(int i = ch.length - 1; i >= 0 ; i--)
        {           
            if(ch[i] != ' ' && count != 0)
            {                
                ch[mark-1] = ch[i];
                ch[i] = ' ';                
                mark--;
                if(i != 0 && ch[i-1] == ' ')
                {
                    mark -= 3;
                    count--;
                }
            }
        }
    }
    
    public void URLify(char[] ch, int len)
    {      
        makeRoom(ch, len);
        
        if(len != 0)
        {
            for(int i=0; i < ch.length; i++)
            {
                if(ch[i] == ' ')
                {
                    ch[i] = '%';
                    ch[i+1] = '2';
                    ch[i+2] = '0';
                    i = i+2;
                }
            }
        }
        
        
    }
    
    public static void main(String [ ] a)
    {
        URL x = new URL();
        String s = "Mr John Smith    ";
        char[] ch = s.toCharArray();
        x.URLify(ch, 13);
        System.out.println(ch);
    }
}
