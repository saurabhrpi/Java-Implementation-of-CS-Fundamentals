class Solution {
    public boolean isHappy(int n) {
        int sum = 0;  
        int div = n;        
        int dig = 0; 
        Map<Integer,Integer> map = new HashMap<>();
        
        // sum stores intermediate sum values (when div is not yet 0) as well. We want to make sure if we  
        // get out then at that moment sum = 1 AND div = 0, i.e. not at the time of intermediate sum but at the 
        // time of final sum.
        while(div != 0 || sum != 1) // or (!(sum == 1 && div == 0))
        {
            if(div == 0)
            {
                if(!map.containsKey(sum))
                {
                    map.put(sum,1);
                }
                else
                {
                    return false;
                }
                div = sum;
                sum = 0;
            }
            dig = div%10;
            sum += (int)(Math.pow(dig,2));
            div = div/10;
        }
        return true;        
    }
}
