import java.util.*;
import java.lang.*;
import java.io.*;


public class TripleStep{
    
    // naive
    // runtime : 3^n
    int count(int steps)
    {
       if(steps < 0) return 0;
       if(steps == 0) return 1; // we can exclude this if we decide for steps == 0 ways will be 0 too
       return count(steps - 3) + count(steps - 2) + count(steps - 1);
    }
    
    //optimal
    
    int countWays(int steps)
    {
        int[] memo = new int[steps + 1]; // 1 more than length will ensure no arrayindexoutofBounds exception at memo[steps]
        Arrays.fill(memo, -1);
        return countWays(memo, steps);
    }
    
    int countWays(int[] memo, int steps)
    {
        if(steps < 0) return 0;
        if(steps == 0) return 1;
        if(memo[steps] > -1)  // caching 
        {
            return memo[steps];
        }
        memo[steps] = countWays(memo, steps - 1) + countWays(memo, steps - 2) + countWays(memo, steps - 3);
        return memo[steps];
    }
    
    public static void main(String[] args)
    {

    }
    
}
