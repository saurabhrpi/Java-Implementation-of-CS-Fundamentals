class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return Integer.MIN_VALUE;
        }        
        
        int ls = nums[0], rs = nums[0];
        
        for(int i=1; i < nums.length; i++)
        {
            //rs = Math.max(rs + nums[i], nums[i]);
            if(rs + nums[i] > nums[i])
            {
                rs = rs + nums[i];
            }
            else
            {
                rs = nums[i];
            }
            
            if(ls < rs)
            {
                ls = rs;
            }            
        }
        return ls;
    }
}
    
