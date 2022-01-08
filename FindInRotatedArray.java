class Solution {
    public int search(int[] nums, int target) {     
        // My Approach. Faster than 20%
        //return search(nums, target, 0, nums.length - 1);
        
        // Approach given. Faster than 10%.
        int min = findIndexOfMin(nums);
        System.out.println("min " + min);
        if(nums[min] == target)
            return min;        
        if(min == 0 || target < nums[0])
            return binarySearch(nums, min, nums.length - 1, target);                            
        if(target > nums[nums.length - 1])
            return binarySearch(nums, 0, min, target);
        return -1;
    }
    
    public int findIndexOfMin(int[] nums)
    {
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right)
        {
            mid = (left + right)/2;            
            if(nums[mid] > nums[right])
                left = mid + 1;
            else if(nums[left] <= nums[mid])
                return left;
            else if(nums[left] > nums[right])
                right = mid;
            System.out.println("left " + left);
        }
        return left;
    }
    
    public int binarySearch(int[] nums, int left, int right, int val)
    {        
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(nums[mid] == val)
                return mid;
            if(nums[mid] > val)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    
    // Faster than 20%.
    public int search(int[] nums, int target, int left, int right)
    {
        if(left > right || left < 0 || right >= nums.length)
            return -1;
        int mid = (left + right)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[right] == target)
            return right;
        if(nums[mid] < target)
        {
            if(nums[mid] > nums[right])
                return search(nums,target,mid + 1, right);
            if(nums[right] < target)
                return search(nums,target,left, mid - 1); 
            return search(nums,target,mid + 1, right);
        }
        if(nums[mid] < nums[right])
            return search(nums,target,left, mid - 1);
        if(nums[right] > target)
            return search(nums,target,mid + 1, right);
        return search(nums,target,left, mid - 1);
    }
}
