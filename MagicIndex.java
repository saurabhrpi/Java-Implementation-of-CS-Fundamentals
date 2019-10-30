import java.util.*;
import java.lang.*;
import java.io.*;


public class MagicIndex{
    
    // When elements are distinct
    
    public int search(int[] array)
    {
        if(array == null || array.length == 0) return -1;
        
        return searchD(array, 0, array.length - 1);
    }
    
    public int searchD(int[] array, int start, int end)
    {
        if(end < start)
        {
            return -1;
        }
        
        int mid = (start + end) / 2;
        
        if(array[mid] == mid) return mid;
        else if(array[mid] > mid) return searchD(array, start, mid - 1);
        
        return searchD(array, mid + 1, end); 
    }
    
    // When elements may not be distinct
    
    public int search(int[] array, int start, int end)
    {
        if(end < start) return -1;
        
        int midInd = (start + end) / 2;
        int midVal = array[midInd];
        
        if(midInd == midVal) return midInd;
        
        int leftInd = Math.min(midInd - 1, midVal); // in case val < ind, start the left search from (ind - 1) <= val. 
        
        int x = search(array, start, leftInd);
        if(x >= 0)
        {
            return x;
        }
        
        int rightInd = Math.max(midInd + 1, midVal);
        return search(array, rightInd, end);
        
    }
    
    public static void main(String[] args)
    {

    }
    
}
