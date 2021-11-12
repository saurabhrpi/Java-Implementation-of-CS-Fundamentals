class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return givenSolution(matrix);   
    }
    
    public List<Integer> givenSolution(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0) return null;
        
        int rows = matrix.length, col = matrix[0].length;
        int up = 0, down = rows - 1, left = 0, right = col - 1;
        
        List<Integer> result = new ArrayList<Integer>();
        
        while(result.size() < rows*col)
        {            
            for(int i = left; i <= right; i++)
            {
                result.add(matrix[up][i]);
            }
            
            for(int i = up + 1; i <= down; i++)
            {
                result.add(matrix[i][right]);
            }
            
            if(up != down) // cuz 'up' row is already traversed above
            {
                for(int i = right - 1; i >= left; i--)
                {
                    result.add(matrix[down][i]);   
                }                
            }
            
            if(left != right)
            {
                for(int i = down - 1; i > up; i--) // will not be traversing up = 'up' but > 'up'.
                {
                    result.add(matrix[i][left]);
                }   
            }
            up++;
            down--; // cuz when we move one down from top, we also move one up from bottom.
            right--;
            left++;
        }
        return result;
    }
    
    public List<Integer> myImpl(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0) return null;
        
        int rowOffset = 0, colOffset = 0;
        List<Integer> result = new ArrayList<Integer>();
        boolean isTraversingRow = true;        
        int size = matrix.length * matrix[0].length;
        
        while(rowOffset < matrix.length/2 && colOffset < matrix[0].length/2)
        {
            //if(isTraversingRow)
            //{            
            int row = rowOffset, col = colOffset;
            //System.out.println("row " + row);
            //System.out.println("col " + col);
            //System.out.println("offset " + offset);
            
            while(col <= matrix[0].length - 1 - colOffset)
            {
                System.out.println("traversing row");
                result.add(matrix[row][col]);
                col++;
            }
            if(col > matrix[0].length - 1 - colOffset)
                col--; 
            row++;
            while(row < matrix.length - rowOffset)
            {
                System.out.println("traversing col");
                result.add(matrix[row][col]);
                row++;
            }
            
            if(row == matrix.length - rowOffset)
                row--;
            
            if(rowOffset < matrix.length/2 && colOffset < matrix[0].length/2)
            {
                col = matrix[0].length - 2 - colOffset;
                while(col > colOffset - 1)
                {
                    System.out.println("traversing row backwards");
                    result.add(matrix[row][col]);
                    col--;
                }
                if(col == colOffset - 1)
                    col++;

                row = matrix.length - 2 - rowOffset;
                while(row > rowOffset)
                {
                    System.out.println("traversing col backwards");
                    result.add(matrix[row][col]);
                    row--;
                }
                if(row == rowOffset)
                    row++;
            }     
            colOffset++;
            rowOffset++;
            //}
        }
        return result;
    }
}
