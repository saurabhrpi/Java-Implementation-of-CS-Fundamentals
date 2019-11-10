import java.util.*;
import java.lang.*;
import java.io.*;

public class SelectionSort{
    
    public void sort(int[] array)
    {
        for(int j = 0; j < array.length; j++)
        {
            int smallest = array[j];
            int ind = j;
            for(int i = j + 1; i < array.length; i++)
            {
                if(smallest > array[i])
                {
                    smallest = array[i];
                    ind = i;
                }
            }
            array[ind] = array[j];
            array[j] = smallest;   
        }
    }
    
    public static void main(String[] args)
    {
        SelectionSort ss = new SelectionSort();
        int[] n = {12, 8, 90, 1, 16, 28, 3};
        ss.sort(n);
        for(int i = 0; i < n.length; i++)
            System.out.println(n[i]);
    }
}   
