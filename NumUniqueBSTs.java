// LeetCode problem #96

class Solution {    
    
    // F(i,n)=G(n−i)⋅G(i−1)
    // Or: Number of subtrees created with i as the root where 1 <= i <= n 
    // is equal to product of number of subtrees created with (i - 1) elements and
    // number of subtrees created with (n - i) elements.
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; // Final sum for n elements is represented by (n+1)th index.
        
        // dp[0] = 1 to make sure 0 isn't returned in future calculations. We only care for values starting
        // dp[1].
        
        /*
         In the below algorithm each outer iteration returns number of subtrees 
         possible for elements from 1 to i. An e.g. for elements between 1 to 3:
        for root =    0    1  
        total trees = 1    1  
        for root =    0    1   2  
        total trees = 1    1  dp[1]*dp[0] + dp[0]*dp[1] = 2
        for root =    0    1   2   3                          
        total trees = 1    1   2   dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0] = 5        
        for root =    0    1   2   3  4                          
        total trees = 1    1   2   5  dp[0]*dp[3] + dp[2]*dp[1] + dp[1]*dp[2] + dp[3]*dp[0] = 14  
        */
        
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) 
        {
            System.out.println("****outer iteration*****");            
            for(int j = 1; j<=i; j++)
            {
                // each iteration represents number of subtrees with
                // only j as root. 
                System.out.println("****inner iteration*****");                
                System.out.print("dp[i-j] for i = " + i +  " and j = " + j + " is " + dp[i - j]);
                System.out.println(" for i - j = " + (i - j));
                System.out.println("dp[j - 1] is " + dp[j - 1] + " for j - 1 = " + (j - 1));                
                dp[i] += dp[i - j]*dp[j - 1]; 
                System.out.println("dp[i] is now " + dp[i]);
            }
            System.out.println("for elements from 1 to " + i + " dp[i] is " + dp[i]);            
        }
        return dp[n]; 
    }
    
}
