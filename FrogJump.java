class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();        
        // Idea is to check whether the last stone has a 'last jump' associated to it. If yes, then return true, else false.
        for(int i = 0; i < stones.length; i++)
        {
            map.put(stones[i],new HashSet<Integer>()); // Hashset used to avoid redundant values in cases for e.g. when last jumps were 1 and 3. Both will yield next possible jumps as 2. And hence going into TLE for some test cases.
        }        
        map.get(0).add(0);        
        for(int i = 0; i < stones.length; i++)
        {         
            //System.out.println("***Start of outermost***");
            for(int s : map.get(stones[i]))
            {
                 //System.out.print("For last jump = " + s + " associated with stones[i] = " + stones[i]);
                 //System.out.println(" for i = " + i);
                for(int k = s - 1; k <= s + 1; k++)
                {
                    //System.out.println("Jump k = " + k);
                    if(k > 0 && map.containsKey(stones[i] + k))
                    {
                        //System.out.println("Putting value: k = " + k + " for key = " + (stones[i] + k));
                        map.get(stones[i] + k).add(k);
                    }
                }
            }
            //System.out.println("***End of outermost****");            
        }
       //System.out.print("stones[stones.length - 1] is ");
        //System.out.println(map.get(stones[stones.length - 1]));
        return map.get(stones[stones.length - 1]).size() > 0; 
    }
}
