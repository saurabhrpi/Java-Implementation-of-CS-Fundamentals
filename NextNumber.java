import java.util.*;
import java.lang.*;

/*
Brute force approach : Increment the number or decrement the number by 1 till we find the next biggest or next smallest number.
*/

/*
Optimal approach
*/

public class NextNumber{
    
    public int getNext(int num)
    {
        int c = num;
        int c0 = 0; //consecutive rightmost zeros
        int c1 = 0; //consecutive rightmost ones
        
        while(((c & 1) == 0) && (c != 0)) 
        {
            c0++;
            c >>= 1;
        }
        
        while(((c & 1) == 1) && (c != 0)) 
        {
            c1++;
            c >>= 1;
        }
        
        // if the given num is like 111...11000..000
        if((c0 + c1 == 31) || (c0 + c1 == 0))
        {
            return -1;
        }
        
        int p = c0 + c1;
        n |= (1 << p); // put 1 at position p
        n &= ~((1 << p) - 1); // cleared all bits from position p-1 through 0
        n |= ((1 << (c1 - 1)) - 1); // just add c1 - 1 ones
        return n;
    }
    
    public static void main(String args[]) 
    {
        
    }
}
