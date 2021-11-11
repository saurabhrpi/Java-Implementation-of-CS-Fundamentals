class Solution {
    public List<Integer> getRow(int rowIndex) {       
        return bruteForce(rowIndex);
        //return optimized(rowIndex);
    }
    
    // O(n) Time and O(n) space :
    //https://leetcode.com/problems/pascals-triangle-ii/discuss/38482/My-12-Lines-of-C%2B%2B-Solution-in-2ms-with-only-one-loop.-O(k)-time-and-O(k)-space.
    
    // To be completed
    public List<Integer> optimized(int rowIndex)
    {
        int val = (int)(Math.pow(11,rowIndex));
        System.out.println("val : " + val);
        String temp = Integer.toString(val);
        //int[] newGuess = new int[temp.length()];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < temp.length(); i++)
        {
            res.add(temp.charAt(i) - '0');
        }
        return res;
    }
    
    public List<Integer> bruteForce(int rowIndex)
    {
        List<Integer> prev = new ArrayList<Integer>();        
        int[] row;    
        List<Integer> r = new ArrayList<Integer>();
        for(int i=1; i <= rowIndex + 1; i++)
        {            
            row = new int[i];
            for(int j=1; j <= i; j++)
            {                
                if(j == 1 || j == i)
                    row[j-1] = 1;
                else
                {            
                    int left = prev.get(j-2);
                    int right = prev.get(j-1);
                    row[j-1] = left + right;
                }
            }            
            for(int k : row)
            {
                r.add(k);
            }
            prev = new ArrayList<Integer>(r);
            r.clear();
        }
        return prev;
    }
}
