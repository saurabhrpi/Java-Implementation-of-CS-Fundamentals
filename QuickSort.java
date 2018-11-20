import java.util.*;
import java.lang.*;

public class QuickSort{
    
    public void quickSortHelper(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }
    
    public void quickSort(int[] arr, int left, int right)
    {
        System.out.println("Starting with left = " + left);
        System.out.println("Starting with right = " + right);
        
        int index = partition(arr, left, right);
        
        System.out.println("index returned : " + index);
        
        if(left < index - 1) // becz we increase left (returned) by 1 before returning from partition
        {
            quickSort(arr, left, index - 1);
        }
        
        if(index < right)
        {
            quickSort(arr, index, right);
        }
    }
    
    public int partition(int[] arr, int left, int right)
    {
        int pivot = arr[(left+right)/2];
        
        System.out.println("pivot is " + pivot);
        
        while(left <= right)
        {
            while(arr[left] < pivot) 
            {
                System.out.println("incrementing left");
                left++;
            }
            
            while(arr[right] > pivot)
            {
                System.out.println("decrementing right");
                right--;
            }
            
            if(left <= right)
            {
                System.out.println("before swap, left is " + left);
                swap(arr, left, right);
                left++;
            }
        }
        return left;
    }
    
    public void swap(int[] arr, int left, int right)
    {
        System.out.println("swapping " + arr[left] + " with " + arr[right]);
        int k = arr[left];
        arr[left] = arr[right];
        arr[right] = k;
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
        
        QuickSort qs = new QuickSort();
        
        qs.quickSortHelper(array);
        
        for(int i=0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
