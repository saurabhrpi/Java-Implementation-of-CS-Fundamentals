class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[1,7,5,2]
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++)
        {     
            if(map.containsKey(nums[i]))
            {
                List<Integer> val = map.get(nums[i]);
                // second check ensures the found value is not nums[i] itself.
                if(val.size() == 1 && (val.get(0) != i)) 
                {
                    res[0] = i;
                    res[1] = val.get(0);
                    break;
                }
                else if(val.size() == 2)
                {                   
                    res[0] = val.get(0);
                    res[1] = val.get(1);
                    break;
                }                
            }
            else
            {
                List<Integer> val;
                if(!map.containsKey(target-nums[i]))  
                {
                   val =  new ArrayList<Integer>();               
                }
                else
                {
                    val = map.get(target-nums[i]);                
                }
                val.add(i);
                map.put(target-nums[i],val);           
            }            
        }       
        return res;
    }
}
