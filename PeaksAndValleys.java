import java.util.*;
import java.lang.*;
import java.io.*;

// 2,1,3,3,5 is an accepted answer for the test case given in the ques.


public class PeaksAndValleys{
    
    public void arrange(int[] array)
    {
        Arrays.sort(array);
        for(int i= 0; i < array.length - 1; i += 2)
        {
            swap(array, i, i + 1);
        }
    }
    
    public void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    //optimal solution
    
    // By swapping with the larger of the two adjacent elements provided the larger adjacent element
    // is in turn larger than this one too, we ensure we have a peak in the middle.
    void sortValleyPeak(int[] array)
    {
        for(int i=1; i < array.length; i += 2)
        {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if(i != biggestIndex)
            {
                swap(array, i, biggestIndex); // order won't matter
            }
        }
    }
    
    int maxIndex(int[] array, int a, int b, int c)
    {
        int len = array.length;
        int aVal = a >= 0 && a < len? array[a] : Integer.MIN_VALUE;
        int bVal = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cVal = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
        
        int max = Math.max(aVal, Math.max(bVal, cVal)); // find the max of 3
        if(aVal == max)
        {
            return a;
        }
        else if(bVal == max)
        {
            return b;
        }
        
        return c;
    }
    
    public static void main(String[] args)
    {
       PeaksAndValleys p = new PeaksAndValleys();
       int[] n  = {5,3,1,2,3};
       p.arrange(n);
       for(int i=0; i < n.length; i++)
       {
           System.out.println(n[i]);
       }
    }
    
}
