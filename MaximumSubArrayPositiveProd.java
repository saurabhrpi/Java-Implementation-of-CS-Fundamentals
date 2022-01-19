class Solution {
    public int getMaxLen(int[] nums) {
        // -2,-1,-1,-2,8 //4
        // -2,-1,-1,8,-2 //5
        // -2,-1,-1,0,-2 //2
        int curr = 1;
        int start = 0, maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
                curr *= -1;
            else if(nums[i] > 0)
                curr *= 1;
            else if(nums[i] == 0)
                curr = 0;            
            if(curr == 0)                
            {
                start = i + 1;
                curr = 1;
            }            
            if((curr > 0) && (maxCount < (i - start + 1)))
            {                   
                maxCount = (i - start + 1);                
            }                
        }
        curr = 1; start = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] < 0)
                curr *= -1;
            else if(nums[i] > 0)
                curr *= 1;
            else if(nums[i] == 0)
                curr = 0;
            if(curr == 0)                
            {
                start = i - 1;
                curr = 1;
            }            
            if((curr > 0) && (maxCount < (start - i + 1)))
            {
                maxCount = Math.max(maxCount,(start - i + 1));            
            }                
        }
        return maxCount == Integer.MIN_VALUE? 0 : maxCount;
    }
}
