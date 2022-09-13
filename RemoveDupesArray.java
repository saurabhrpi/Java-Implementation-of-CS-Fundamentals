// Leetcode problem #26

class Solution {
    public int removeDuplicates(int[] nums) {
        
        //0,0,1,1,1,2,2,3,3,4 // i = 0, n's index = 0.
        //0,0,1,1,1,2,2,3,3,4 // i = 1, n's index = 1.
        //0,1,1,1,1,2,2,3,3,4 // i = 2, n's index = 2.
        //0,1,1,1,1,2,2,3,3,4 // i = 2, n's index = 3.
        //0,1,1,1,1,2,2,3,3,4 // i = 2, n's index = 4.
        //0,1,2,1,1,2,2,3,3,4 // i = 3, n's index = 5. 
        //0,1,2,1,1,2,2,3,3,4 // i = 3, n's index = 6
        //0,1,2,3,1,2,2,3,3,4 // i = 4, n's index = 7
        //0,1,2,3,1,2,2,3,3,4 // i = 4, n's index = 8
        //0,1,2,3,4,2,2,3,3,4 // i = 5, n's index = 9
      
        int i = 0; // i = 1 + index of last distinct num.
        for (int n : nums)
        {
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;   
        }            
        return i;
    }
}
