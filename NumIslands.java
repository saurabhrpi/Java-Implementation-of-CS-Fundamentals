import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {                
       int islands = 0;
       for(int i = 0; i < grid.length; i++)
       {
           for(int j = 0; j < grid[0].length; j++)
           {
               if(grid[i][j] == '1')
               {
                    markAndDrownIslands(grid, i, j);
                    islands++;   
               }               
           }
       }
       return islands;
    }
    
    public void markAndDrownIslands(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        markAndDrownIslands(grid, i, j + 1);
        markAndDrownIslands(grid, i + 1, j);
        markAndDrownIslands(grid, i - 1, j);
        markAndDrownIslands(grid, i, j - 1);
    }
}
