import java.util.*;
import java.lang.*;

public class MoveZeroes{
    
    public void move(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return;
        }
        
        int insertPos = 0;
        for(int num : nums)
        {
            if(num != 0)
            {
                nums[insertPos++] = num;
            }
        }
        
        while(insertPos < nums.length)
        {
            nums[insertPos++] = 0;
        }
    }
    
    public static void main(String [] args)
    {
        int[] n = {12, 0, 9, 0, 4};
        (new MoveZeroes()).move(n);
        
        for(int i : n)
        {
            System.out.println(i);
        }
    }
}
