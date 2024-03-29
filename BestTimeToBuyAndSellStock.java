class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProf = 0;
        for(int i=0; i< prices.length; i++)
        {            
            if(prices[i] < minPrice)
            {
                minPrice = prices[i];
            }
            else if(maxProf < prices[i] - minPrice)
            {
                maxProf = prices[i] - minPrice;
            }
        }
        return maxProf;
    }
}
