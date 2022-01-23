// Leetcode problem #1877
// Slightly better solution at : https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/discuss/1380693/simple-java-O(n)-solution-runtime-7ms-beats-100

class Solution {
    
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1; 
        while(left < right)
        {
            int sum = nums[left] + nums[right];
            if(max < sum)
                max = sum;
            left++;
            right--;
        }
        return max;
    }   
}
