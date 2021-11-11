class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n]);
    }
    
    public int climbStairs(int n, int[] memo)
    {
        if(n == 1 || n == 2) return n;
        if(memo[n-1] == 0)
        {
            memo[n-1] = climbStairs(n-1, memo) + climbStairs(n-2, memo);      
        }        
        return memo[n-1];
    }    
}
