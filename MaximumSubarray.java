class Solution {
    public int maxSubArray(int[] nums) {
        // My practice of given solution 
        if(nums.length == 1)
            return nums[0];
        int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i] + currentSubArray)
                currentSubArray = nums[i];
            else
                currentSubArray = nums[i] + currentSubArray;
            if(maxSubArray < currentSubArray)
                maxSubArray = currentSubArray;
        }
        
        return maxSubArray;
        
        //*****Given solution*****
        /*
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            System.out.println("comparing between " + num + ", and " + (currentSubarray + num));
            currentSubarray = Math.max(num, currentSubarray + num);            
            System.out.println("new currentSubarray: " + currentSubarray);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
            System.out.println("new maxSubarray: " + maxSubarray);
        }
        
        return maxSubarray;
        */
    }
}
