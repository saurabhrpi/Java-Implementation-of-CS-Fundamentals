import java.util.*;
import java.lang.*;

//9.01

enum STATE { BIG, SMALL}; 

public class peaksAndValleys{
    
    public STATE prev = STATE.NULL;
    public STATE next = STATE.NULL;
    
    public boolean inOrder = true;
    
    public void sort(int[] arr)
    {
        for(int i=1; i < arr.length; i++)
        {
            if(arr[i] >= arr[i-1])
            {
                if(prev == STATE)
                {
                   swap(arr, arr[i], arr[i-1]);
                }
            }
            else if(arr[i] <= arr[i+1])
            {
                isSmaller = true;
                if(!isGreater)
                {
                    continue;
                }
            }
        }
    }
}
