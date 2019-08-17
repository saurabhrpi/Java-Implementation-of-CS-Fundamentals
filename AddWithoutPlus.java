import java.util.*;
import java.lang.*;

public class MyClass{
    // recursive
    int add(int a, int b)
    {
        if(b == 0)
            return a;
        
        int sum = a ^ b;
        int carry = (a & b) << 1; // To understand this, look at the carry as a digit that is written on top of the first row of number.
        
        return add(sum, carry); // sum + carry will always be = the answer. In the end, carry will always be = 0.
    }
    
    //iterative
    int addIt(int a, int b)
    {
        while(b != 0)
        {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
