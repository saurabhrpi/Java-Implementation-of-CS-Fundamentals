class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //return iterativeImpl(cost);
        int[] minimumCost = new int[cost.length + 1];        
        return dpImpl(cost.length, cost, minimumCost);
    }
    
    public int dpImpl(int index, int[] cost, int[] minimumCost)
    {
        if(index <= 1) return 0;
        
        if(minimumCost[index] == 0)
        {
            int oneStep = cost[index-1] + dpImpl(index-1,cost,minimumCost);
            int twoStep = cost[index-2] + dpImpl(index-2,cost,minimumCost);
            minimumCost[index] = Math.min(oneStep,twoStep);
        }
        return minimumCost[index];
    }
    
    public int iterativeImpl(int[] cost)
    {
        if(cost.length == 0) return 0;
        if(cost.length == 1) return cost[0];
        
        int[] minimumCost = new int[cost.length + 1];
        for(int i = 2; i <= cost.length; i++)
        {
            int oneStep = minimumCost[i-1] + cost[i-1];
            int twoStep = minimumCost[i-2] + cost[i-2];
            minimumCost[i] = Math.min(oneStep, twoStep);
        }
        return minimumCost[cost.length];
    }
}
