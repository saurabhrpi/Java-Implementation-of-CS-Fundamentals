class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int low, int high)
    {
        if(low == high) // will always have this case at the end of call stack
            return low;
        
        System.out.println("****Start of new call****");
        System.out.println("low = " + low + " and high =" + high);
        int mid1 = (low + high)/2;
        int mid2 = mid1 + 1;
        System.out.println("mid1 = " + mid1 + " and mid2 =" + mid2);
        System.out.println("nums[mid1] = " + nums[mid1] + " and nums[mid2] =" + nums[mid2]);
        if(nums[mid1] > nums[mid2])
        {            
            System.out.println("calling helper for low = " + low + ", mid1 =" + mid1);
            return helper(nums, low, mid1);
        }
        System.out.println("calling helper for mid2 = " + mid2 + ", high =" + high);
        return helper(nums, mid2, high);        
    }
}
