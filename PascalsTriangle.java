class Solution {
    public List<List<Integer>> generate(int numRows) {        
        //List<List<Integer>> rows = new ArrayList<List<Integer>>();        
        //return bruteForce(numRows, rows);
        return cleanAndConcise(numRows);
    }
    
    public List<List<Integer>> cleanAndConcise(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1); // Add 1 at every level in the first position. 
            // Once we reach level = 3, start updating from the cell right next to the
            // newly added cell. Value will be = existing value of the cell + value of its next cell.
            // Exactly like shown in the gif in the question.
            for(int j=1;j<row.size()-1;j++) // won't touch the last element.
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

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
