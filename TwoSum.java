import java.util.*;
import java.lang.*;

public class TwoSum{
        
        public int[] twoSum(int[] nums, int target)
        {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            
            int[] result = new int[2];
            
            for(int i=0; i < nums.length; i++)
            {
                if(map.containsKey(target - nums[i]))
                {
                    result[1] = i;
                    result[0] = map.get(target - nums[i]);
                }
                else
                {
                    map.put(nums[i],i);
                }
            }
            
            return result;
        }
        
        public static void main(String[] args)
        {
          int[] nums = {2, 11, 15, 7};
          int target = 18;
          
          int[] res = (new TwoSum()).twoSum(nums, target);
          
          System.out.println(res[0]);
          System.out.println(res[1]);
        }
}
