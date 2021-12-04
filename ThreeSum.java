class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // Result will have all lists distinct because we won't be going
       // over the same number again either as i or low or high.
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(i == 0 || nums[i - 1] != nums[i])
            {
                twoSum(nums, i, results);
            }
        }
        return results;
    }
    
    public void twoSum(int[] nums, int i, List<List<Integer>> results)
    {
        int low = i + 1, high = nums.length - 1;
        while(low < high)
        {
            int sum = nums[i] + nums[low] + nums[high];
            if(sum < 0)
            {
                low++;
            }
            else if(sum > 0)
            {
                high--;
            }
            else
            {
                List<Integer> l = new ArrayList<Integer>();
                l.add(nums[i]);
                l.add(nums[low]);
                l.add(nums[high]);
                results.add(l);
                low++;
                high--; // cuz same high cannot give 0 again as low has increased.
                while(low < high && nums[low] == nums[low - 1]) // low has already increased by 1.
                    low++;
            }
        }
    }
