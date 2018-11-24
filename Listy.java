import java.util.*;
import java.lang.*;

//11:00
public class Listy{
    
    int[] arr;
    
    Listy(int[] arr)
    {
        this.arr = arr;
    }
    
    public int elementAt(int i)
    {
        try
        {
            return arr[i];   
        }
        catch(Exception ex)
        {
            return -1;
        }
    }
    
    public int search(int val)
    {
        int index = 1;
        while(elementAt(index) != -1 && elementAt(index) < val)
        {
            index *= 2;  // runs in log n
        }
        
        // return search(0, val, val);
        return searchBook(index/2, index, val);
    }
    
    public int searchBook(int low, int high, int val)
    {
        int mid;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            int middle = elementAt(mid);
            if(middle == -1 || middle > val)
            {
                high = mid - 1;
            }
            else if(middle < val)
            {
                low = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
    
    public int search(int low, int high, int val)
    {
        if (high < low)
        {
            return -1;
        }
        
        int mid = (low + high)/ 2;
        
        System.out.println("high " + high);
        //System.out.println("low " + low);
        //System.out.println("mid " + mid);
        
        int r = elementAt(mid);
        
        if(r == val)
        {
            return mid;
        }
        
        if(r != -1)
        {
            int ret = search(mid + 1, high, val);
            if(ret == -1)
            {
                return search(low, mid - 1, val);
            }
            return ret; 
        }
        
        if(r == -1)
        {
            return search(low, mid - 1, val);
        }
        
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {
        2,
        6,
        7,
        11,
        22,
        30,
        33,
        33,
        38,
        70,
        81
        };
        
        Listy l = new Listy(arr);
        
        System.out.println(l.search(70));
        //System.out.println(l.elementAt(70));
    }
}
