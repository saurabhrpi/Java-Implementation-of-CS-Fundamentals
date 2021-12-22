// LeetCode problem #96

class Solution {    
    
    // F(i,n)=G(i−1)⋅G(n−i)
    // Or: Number of subtrees created with i as the root where 1 <= i <= n 
    // is equal to product of number of subtrees created with (i - 1) elements and
    // number of subtrees created with (n - i) elements.
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; // Final sum for n elements is represented by (n+1)th index.
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) 
        {
            // each iteration represents number of subtrees with
            // only j as root. So, total subtrees for all numbers from 1 to j
            // as root is the sum of all iterations and saved as dp[i].
            for(int j = 1; j<=i; j++)
            {
                dp[i] += dp[j - 1]*dp[i - j]; // can't keep index to j instead of j-1, otherwise it will be 0.
            }
        }
        return dp[n]; 
    }
    
}
