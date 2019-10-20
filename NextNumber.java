import java.util.*;
import java.lang.*;

/*
Brute force approach : Increment the number or decrement the number by 1 till we find the next biggest or next smallest number.
*/

/*
Optimal bit manipulation approach
*/

public class NextNumber{
    
    public int getNext(int num)
    {
        int c = num;
        int c0 = 0; //consecutive rightmost trailing zeros
        int c1 = 0; //consecutive rightmost non-trailing ones
        
        // order of while loops below is important. We don't want to miss counting 0s if they appear rightmost
        
        while(((c & 1) == 0) && (c != 0)) 
        {
            c0++;
            c >>= 1;
        }
        
        while(((c & 1) == 1) ) //&& (c != 0)) // No need to check for zero as it can never be = 1 & = 0.
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
    
    public int getPrev(int num)
    {
        int temp = num;
        int c0 = 0; // non-trailing zeros
        int c1 = 0; // trailing ones
        
        while((temp & 1) == 1)
        {
            c1++;
            temp >>= 1;
        }
        
        if(temp == 0)
            return -1; // no zeros exist
        
        while(((temp & 1) == 0) && temp != 0)    
        {
            c0++;
            temp >>= 1;
        }
        
        int p = c0 + c1;
        int x = ~0;
        num &= (x << (p + 1)); // cleared all the bits from position p to 0
        
        int mask = (1 << (c1 + 1)) - 1; // for c1+1 ones immediately to the right of p
        num |= mask << (c0 - 1); // for c0-1 zeros immediately following above ones
        
        return num;
    }
    
    public static void main(String args[]) 
    {
        
    }
}
