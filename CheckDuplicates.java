import java.util.*;
import java.lang.*;
import java.io.*;

// array is sorted.

class BitSet{
    int[] bitSet;
    
    public BitSet(int size)
    {
        bitSet = new int[(size >> 5) + 1];
    }   
    
    public boolean get(int pos)
    {
        int wordNumber = (pos >> 5); // block #.
        int bitNumber = (pos & 0x1F); // offset #. 0x1F is 31. &'ing with it is same as mod 32.
        return (bitSet[wordNumber] & (1 << bitNumber)) != 0; // check whether bit corresponding to this int is already set
    }
    
    public void set(int pos)
    {
        int wordNumber = (pos >> 5); // block #.
        int bitNumber = (pos & 0x1F); // 0x1F is 31. offset #.
        bitSet[wordNumber] |= (1 << bitNumber); // set the bit corresponding to this int
    }
}

public class FindDuplicates{
    
    void checkDuplicates(int[] array)
    {
        BitSet bs = new BitSet(array.length);
        for(int i=0; i < array.length; i++)
        {
            int num = array[i];
            int num0 = num - 1; // we're setting the index corresponding to the num
            if(bs.get(num0))
            {
                System.out.println(num);
            }
            else
            {
                bs.set(num0);
            }
        }
    }
    
    public static void main(String[] args)
    {
        FindDuplicates f = new FindDuplicates();
        int[] arr = {1,2,3,4,5,5,6,6,7,7};
        f.checkDuplicates(arr);
    }
    
}
