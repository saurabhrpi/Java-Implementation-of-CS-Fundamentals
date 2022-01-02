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
    
    /*
    // DFS. Faster than 100%.    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, 0, 0, false, result, visited);
        return result;
    }
    
    public void dfs(int[][] matrix, int row, int col, boolean goingUp, List<Integer> result, boolean[][] visited)
    {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
        {
            return;
        }
        if(visited[row][col])
            return;
        
        result.add(matrix[row][col]);
        visited[row][col] = true;        
        if(goingUp)
            dfs(matrix, row - 1, col, true, result, visited);
        
        dfs(matrix, row, col + 1, false, result, visited);
        dfs(matrix, row + 1, col, false, result, visited);
        dfs(matrix, row, col - 1, false, result, visited);
        dfs(matrix, row - 1, col, true, result, visited);        
    }    
}
*/
}
