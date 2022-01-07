class Solution {
    // BFS : Faster than 13%. Iterative faster than 100%.
    public int findMin(int[] nums) {
        //return bfs(nums, 0, nums.length - 1, nums[0]);
        int left = 0, right = nums.length - 1;
        while(left < right)
        {            
            int mid = (left + right)/2;            
            if(nums[mid] > nums[right])
                left = mid + 1;
            else if(nums[left] <= nums[mid]) // to account for case when left == mid.
                return nums[left];
            else
            {
                right = mid;
                left++;
            }            
        }
        return nums[left];
    } 
    
    // Reason I needed == at line 11 and not in recursion below is cuz i m already passing
    // nums[mid] to the last call of the stack where begin > end and mid == begin of prev call.
    
    public int bfs(int[] nums, int begin, int end, int minSoFar)
    {
        if(begin > end || begin < 0 || end >= nums.length)
             return minSoFar;        
        int mid = (begin + end)/2;        
        if(nums[end] < nums[mid]) // right side
            return bfs(nums,mid + 1, end, nums[end]);                
        if(nums[begin] < nums[mid])
            return nums[begin];        
        return bfs(nums,begin + 1, mid, nums[mid]);// left side
    }
}
