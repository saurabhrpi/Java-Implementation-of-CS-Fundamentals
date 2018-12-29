import java.util.*;
import java.lang.*;

public class MaxProfit{
    public int maximize(int[] prices)
    {
        if(prices.length == 0)
        {
            return 0;
        }
        
        int soFarMin = prices[0];
        int max = 0;
        
        for(int i=0; i < prices.length; i++)
        {
            if(prices[i] <= soFarMin)
            {
                soFarMin = prices[i];
            }
            else
            {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        
        return max;
    }
}
