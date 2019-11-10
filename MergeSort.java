import java.util.*;
import java.lang.*;
import java.io.*;

public class MergeSort{
    
    public void mergeSort(int[] array)
    {
        int [] helper = new int[array.length];
        mergeSort(array, helper, 0 , array.length - 1);
    }
    
    void mergeSort(int[] array, int[] helper, int low, int high)
    {
        if(low < high)
        {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }
    
    public void merge(int[] array, int[] helper, int low, int middle, int high)
    {
        // no need for low < high check as it's already done above
        for(int i = low; i <= high; i++)
        {
            helper[i] = array[i];
        }
        
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        
        while(helperLeft <= middle && helperRight <= high)
        {
            if(helper[helperLeft] <= helper[helperRight])
            {
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else
            {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        
        // right side not required since we are replacing digits in array starting from left.
        int remaining = middle - helperLeft;
        for(int i=0; i <= remaining; i++)
        {
            array[current + i] = helper[helperLeft + i];
        }
    }
    
    public static void main(String[] args)
    {
        MergeSort ss = new MergeSort();
        int[] n = {12, 8, 90, 1, 16, 28, 3};
        ss.mergeSort(n);
        for(int i = 0; i < n.length; i++)
            System.out.println(n[i]);
    }
}   
