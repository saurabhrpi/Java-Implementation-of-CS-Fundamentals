// LC problem # 35

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;
        if(target > nums[nums.length - 1])
            return nums.length;
        int low = 0, high = nums.length - 1, prev = 0;        
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(target == nums[mid])
                return mid;
            if(target > nums[mid])
                low = mid + 1;
            else
            {
                high = mid - 1;
                prev = mid;
            }                
        }        
        return prev;
    }
}
