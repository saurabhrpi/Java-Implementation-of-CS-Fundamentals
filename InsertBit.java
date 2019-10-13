import java.util.*;
import java.lang.*;

public class Insertion{
    
    public static void main(String[] args)
    {
        Insertion i = new Insertion();
        System.out.println(i.insert(9, 8, 2, 4));
    }
    
    public int insert(int m, int n, int i, int j)
    {
        int mask = ~0; // not same as 1
        
        int lMask = (mask << (j+1)); //jth position is 0
        int rMask = (1 << i) - 1; // 0s from positions : i thru 0
        
        int merged = lMask | rMask;
        
        int n_cleared = n & merged;
        
        int res = n_cleared | (m << i);
        
        return res;
    }
}
