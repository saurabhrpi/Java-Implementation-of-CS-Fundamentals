import java.util.*;
import java.lang.*;

class CustomSort implements Comparator{
    
    public String sort(String str)
    {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public int compare(Object a, Object b)
    {
        String sa = sort((String)a);
        String sb = sort((String)b);
        
        return sa.compareTo(sb);
    }
}

public class CS{
    
    public void solve(String[] arr)
    {
        Arrays.sort(arr, new CustomSort());
    } 
    
    public static void main(String[] args)
    {
        String[] arr = {
        "bc",
        "de",
        "ef",
        "cb",
        "df",
        "fe",
        "gh",
        "ed"
        };
        
        CS as = new CS();
        
        as.solve(arr);
        
        for(int i=0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
