class Solution {
    public List<List<Integer>> generate(int numRows) {        
        List<List<Integer>> rows = new ArrayList<List<Integer>>();        
        return bruteForce(numRows, rows);
        //return optimized(numRows, rows);
    }
    
    // for recursive solution, refer to :
    // https://leetcode.com/problems/pascals-triangle/discuss/38220/Recursive-solution-Java.-1-ms
    
    //optimized() didn't work like 
    //https://leetcode.com/problems/pascals-triangle/discuss/38182/Short-C%2B%2B-solution-using-only-O(k)-extra-space . Reason being once the list is updated at a lower level, the previous rows also get updated. 
    public List<List<Integer>> optimized(int numRows, List<List<Integer>> rows)
    {
        List<Integer> r = new ArrayList<Integer>();
        for(int i=0; i < numRows; i++)
        {
            r.add(1);
            for(int j=i-1; j>0; j--)
            {
                r.set(j,(r.get(j) + r.get(j-1)));
            }            
            rows.add(r);
        }        
        return rows;
    }
    
    //space complexity can be reduced to O(n) from O(n^2).
    public List<List<Integer>> bruteForce(int numRows, List<List<Integer>> rows)
    {
        for(int i=1; i <= numRows; i++)
        {
            int[] cells = new int[i];    
            for(int j=1; j<=i; j++)
            {
                if(j == 1 || j == i)
                {
                    cells[j-1] = 1;   
                }
                else
                {                   
                    int left = rows.get(i-2).get(j-2);
                    int right = rows.get(i-2).get(j-1);
                    cells[j-1] = left + right;                                         
                }
            }
            List<Integer> r = new ArrayList<Integer>();
            for(int k : cells)
            {
                r.add(k);
            }
            rows.add(r);
        }
        return rows;
    }
}
