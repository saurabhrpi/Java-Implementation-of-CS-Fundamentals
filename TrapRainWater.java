class Solution {
    
    // Easiest to understand and most efficient
    // only downside is a little extra code.
    // For slightly more efficient code and the best solution, refer:
    //https://leetcode.com/problems/trapping-rain-water/discuss/17357/Sharing-my-simple-c++-code:-O(n)-time-O(1)-space
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int tallest = 0;
        for(int i=0; i < height.length; i++)
        {
            if(height[i] > height[tallest])
                tallest = i;
        }
        
        int water = 0, tall = 0;
        for(int i = 0; i < tallest; i++)
        {
            if(height[i] > tall)
                tall = height[i];
            else
                water += tall - height[i];
        }
        
        tall = 0;
        for(int i = height.length - 1; i > tallest; i--)
        {
            if(height[i] > tall)
                tall = height[i];
            else
                water += tall - height[i];
        }
        return water;
    }
}
