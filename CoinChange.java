class Solution {
    public int coinChange(int[] coins, int amount) {                                
        // Brute force
        //return coinChange(coins, amount, 0);
        
        // Top-Down DP. O(A*N) where A is the amount and N is the denomination count.
        if(amount < 1)
            return 0;
        return coinChange(coins, amount, new int[amount]);
    }   
    
        /* Call stack with values outside () representing amount, inside () rep. coin while inside [] represent values returned.
                        11
                    (1)/
                      10
                  (1)/
                   ..
               (1)/
                 2. min is 2. After calling for coin = 2, it becomes 1.
          (1) /[1]   \(2),[0]    \ (5),[-1]       
             /         0          -3
            1         
  (1)/[1] |(2),[0] \(-5),[0]        
    0    -1          -4 
        */
    
    public int coinChange(int[] coins, int amount, int[] count)
    {        
        if(amount < 0) return -1;
        if(amount == 0) return 0;        
        if(count[amount - 1] != 0) return count[amount - 1];
        System.out.println("****Start of a new call w/o return****");   
        int min = Integer.MAX_VALUE;
        // At every level, all coins are at our disposal.
        for(int coin : coins)
        {
            System.out.println("calling for coin = " + coin);
            System.out.println("Passing (amount - coin) as new amount = " + (amount - coin));
            int res = coinChange(coins, amount - coin, count);
            System.out.println("res returned = " + res + " for amount passed = " + (amount - coin) + ", actual amount = " + amount + " and coin = " + coin);
            if(res >= 0 && res < min)
                min = 1 + res; // 1 here is the coin we deducted when we passed (amount - coin) to coinChange().
            System.out.println("min is now " + min);
        }
        count[amount - 1] = (min == Integer.MAX_VALUE?-1 : min);
        System.out.println("returning count[" +  (amount - 1) + "] = " + count[amount - 1]);
        System.out.println("**end of call for amount = " + amount + " *****");
        return count[amount - 1];
    }        
    
}
