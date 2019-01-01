import java.util.*;
import java.lang.*;

public class TrapRainWater{
    
    public int trap(int[] inp)
    {
        int leftMax = 0, rightMax = 0;
        int start = 0, end = inp.length - 1;
        int max = 0;
        
        while(start <= end)
        {
            if(leftMax < rightMax)
            {
                leftMax = Math.max(inp[start], leftMax);
                max += leftMax - inp[start];
                start++;
            }
            else
            {
                rightMax = Math.max(inp[end], rightMax);
                max += rightMax - inp[end];
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] inp = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println((new TrapRainWater()).trap(inp));
    }
}
