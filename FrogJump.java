class Solution {
    public boolean canCross(int[] stones) {
        
        //return can_Cross(stones);
        return rehearseGivenSol(stones);
        // my impl
        /*
        int[] memo = new int[stones.length];
        for(int i=0; i < memo.length; i++)
            memo[i] = 0;
        if(canCross(stones,1,1,1, memo) == 1)
            return true;
        return false;
        */
    }
    
    public boolean rehearseGivenSol(int[] stones)
    {
        HashMap<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        
        for(int i = 0; i < stones.length; i++)
        {
            map.put(stones[i],new HashSet<Integer>());
        }
        
        map.get(0).add(0);
        
        for(int i=0; i < stones.length; i++)
        {
            for(int k : map.get(stones[i]))
            {
                for(int step = k - 1; step <= k + 1; step++)
                {
                    if(step > 0 && map.containsKey(stones[i] + step))
                    {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
    }
    
    // given best solution
    
    public boolean can_Cross(int[] stones)
    {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int i=0; i < stones.length; i++)
        {
            map.put(stones[i],new HashSet<Integer>());
        }
        
        map.get(0).add(0);
        
        for(int i=0; i < stones.length; i++)            
        {
            for(int k : map.get(stones[i]))    
            {
                for(int step = k - 1; step <= k + 1; step++)
                {
                    // 1st condition below will help skip -1 and 0 for stone 0.
                    if(step > 0 && map.containsKey(stones[i] + step)) 
                    {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
    }
    
    // my impl
    public int canCross(int[] stones, int toIndex, int toVal, int byJumpOf, int[] memo)
    {
        if(byJumpOf == 0) return -1;
        if(toIndex == stones.length) return 1;
        if(toIndex > stones.length) return -1;
        if(memo[toIndex] != 0)
            return memo[toIndex];
        int i = toIndex;
        for(; i < stones.length; i++)
        {
            if(toVal == stones[i])
            {
                /*
                System.out.println("found");
                System.out.println("byJumpOf " + byJumpOf);
                System.out.println("toVal " + toVal);
                System.out.println("i " + i);                
                */
                memo[i] = Math.max(Math.max(canCross(stones, i + 1, toVal + byJumpOf, byJumpOf, memo), canCross(stones, i + 1, toVal + byJumpOf + 1, byJumpOf + 1, memo)), canCross(stones, i + 1, toVal + byJumpOf - 1, byJumpOf - 1, memo));                    
                return memo[i];
            }
        }        
        return memo[toIndex]; 
    }
}
