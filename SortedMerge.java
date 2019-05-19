import java.util.*;
import java.lang.*;

public class SortedMerge{
    
    public void merge(int[] a, int[] b, int lastA, int lastB)
    {
        int indexA = lastA - 1; // current position of iterator A
        int indexB = lastB - 1; // current position of iterator B
        int indexMerged = lastA + lastB - 1; // current position of merged array iterator
        
        while(indexB >= 0)
        {
            if(indexA >= 0 && a[indexA] > b[indexB])
            {
                a[indexMerged] = a[indexA];
                indexA--;
            }
            else
            {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
    
    public static void main(String[] args)
    {
        
    }
}
