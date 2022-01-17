// LeetCode Problem #1151
class Solution {
    // 0,0,0,1,1,0,0,1,0,1,0,1,1,0
    // 0,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1       
    public int minSwaps(int[] data) {        
        int right = 0, left = 0, count = 0, maxCount = Integer.MIN_VALUE;
        int ones = 0;
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == 1)
                ones++;
        }
        
        while(right < data.length)
        {            
            count += data[right];            
            if(right - left >= ones)
            {            
                count -= data[left];
                left++;                
            }
            right++;            
            maxCount = Math.max(maxCount, count);
        }
        return ones - maxCount;
    }
}
