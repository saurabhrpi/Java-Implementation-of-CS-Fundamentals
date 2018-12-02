import java.util.*;
import java.lang.*;

public class TS{
    
    public int countWays(int steps)
    {
        int[] memo = new int[steps + 1];
        Arrays.fill(memo,-1);
        return countWays(steps, memo);
    }
    
    public int countWays(int steps, int[] memo)
    {
        if(steps < 0)
        {
            return 0;
        }
        
        if(steps == 0)
        {
            return 1;
        }
        
        memo[steps] = countWays(steps - 3, memo) + countWays(steps - 2, memo) + countWays(steps - 1, memo);
        
        return memo[steps];
    }
    
    public static void main(String[] args)
    {
        TS ts = new TS();
        System.out.println(ts.countWays(3));
    }
}
