import java.util.*;
import java.lang.*;


public class Conversion{
    
    public int determineBits(int A, int B)
    {
        int count = 0;
        
        for(int c = A ^ B; c != 0; c >>= 1)
        {
            count += c & 1;
        }
        return count;
    }
    
    public static void main(String args[]) 
    {
        Conversion c = new Conversion();
        System.out.println(c.determineBits(29,15));
    }
}
