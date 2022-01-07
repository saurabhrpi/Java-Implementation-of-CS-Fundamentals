class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        int prod = 1; // if I set this to nums[0], i will fail the below edge case where I have to reset prod to 1 right after first element 0.
        //[0,3,-1]
        for(int i = 0; i < nums.length; i++)
        {
            prod *= nums[i];
            if(prod > max)
                max = prod;
            if(prod == 0)
                prod = 1;
        }
        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            prod *= nums[i];
            if(prod > max)
                max = prod;
            if(prod == 0)
                prod = 1;
        }
        return max;
    }
}
