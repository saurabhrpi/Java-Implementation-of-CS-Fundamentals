// LC Problem # 739
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> dq = new LinkedList<Integer>();
        
        for(int i = 0; i < temperatures.length - 1; i++)
        {
            if(temperatures[i] < temperatures[i + 1])
            {
                while(true)
                {
                    Integer x = dq.isEmpty()?null:dq.peek();
                    if(x != null && temperatures[x] < temperatures[i + 1])
                    {
                        res[x] = i + 1 - x;
                        dq.pop();
                    }
                    else
                    {
                        res[i] = 1;
                        break;
                    }                        
                }                
            }
            else
            {
                dq.push(i);
            }                
        }
        return res;
    }
}
