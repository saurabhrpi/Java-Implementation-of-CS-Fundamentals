import java.util.*;
import java.lang.*;

public class MergeSort{
    
    public void mergeSort(int[] array)
    {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }
    
    public void mergeSort(int[] array, int[] helper, int low, int high)
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
        // Creating the helper from already sorted arrays
        for(int i = low; i <= high; i++)
        {
            helper[i] = array[i];
        }
        
        int helperL = low;
        int helperR = middle + 1;
        int current = low;
        
        while(helperL <= middle && helperR <= high)
        {
            if(helper[helperL] <= helper[helperR])
            {
                array[current] = helper[helperL];
                helperL++;
            }
            else
            {
                array[current] = helper[helperR];
                helperR++;
            }
            current++;
        }
        
        int remaining = middle - helperL;
        
        for(int i = 0; i <= remaining; i++) // make sure i <= because helperL 's position itself should be copied too.
        {
            array[current + i] = helper[helperL + i];
        }
        
        // no need to copy right as we want that to be greater in value hence where they are right now in the actual array.
    }
    
    public static void main(String[] args)
    {
        int[] array = {
            90,
            10,
            8,
            22,
            18,
            27,
            17
        };
        
        MergeSort ms = new MergeSort();
        
        ms.mergeSort(array);
        
        for(int i=0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
