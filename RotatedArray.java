import java.util.*;
import java.lang.*;

public class RotatedArray{

    public int find(int[] arr, int val)
    {
        return findBook(arr, val, 0, arr.length-1);
    }
    
    public int findBook(int[] arr, int val, int low, int high)
    {
        if(high < low)
        {
            return -1;
        }
        
        int mid = (high + low) / 2;
        
        if(a[mid] == val)
        {
            return mid;
        }
        
        if(arr[low] < arr[mid])
        {
            if(val >= arr[low] && val < arr[mid])
            {
                return findBook(arr, val, low, mid - 1);
            }
            else 
            {
                return findBook(arr, val, mid + 1, high);
            }
        }
        else if(arr[mid] < arr[high])
        {
            if(val > arr[mid] && val <= arr[high])
            {
                return findBook(arr, val, mid + 1, high);
            }
            else 
            {
                return findBook(arr, val, low, mid - 1);
            }
        }
        
        if(arr[low] == arr[mid])
        {
            if(arr[mid] != arr[high])
            {
                return findBook(arr, val, mid + 1, high);
            }
            else
            {
                int r = findBook(arr, val, low, mid - 1);
                if(r == -1)
                {
                    return findBook(arr, val, mid + 1, high);
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {
        13,
        13,
        13,
        13,
        13,
        13,
        13,
        13,
        2,
        6,
        7,
        11,
        12,
        13,
        13,
        13
        };
        
        //AnagramSolver as = new AnagramSolver();
        RotatedArray ra = new RotatedArray();
        
        System.out.println(ra.find(arr, 11));
    }
}	
