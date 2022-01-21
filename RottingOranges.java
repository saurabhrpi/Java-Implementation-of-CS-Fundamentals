// Leetcode problem #994
class Solution {    
    public int orangesRotting(int[][] grid) {       
        List<Integer> res = new ArrayList<>();        
        List<Pair<Integer,Integer>> lp = new ArrayList<>();
        int freshOranges = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 2)
                {                    
                    lp.add(new Pair<Integer,Integer>(i,j));
                }
                else if(grid[i][j] == 1)
                    freshOranges++;
            }            
        }
        
        // BFS
        int count = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();        
        for(int j = 0; j < lp.size(); j++)
            queue.add(lp.get(j));
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                Pair cell = queue.poll();
                Integer k = (Integer)cell.getKey();
                Integer v = (Integer)cell.getValue();                
                if(((k + 1) < grid.length) && (grid[k + 1][v] == 1))
                {                    
                     
                    grid[k + 1][v] = 2;
                    queue.add(new Pair<Integer,Integer>(k + 1, v));
                    freshOranges--;
                } 
                if(((v + 1) < grid[0].length) && (grid[k][v + 1] == 1))
                {            
                    grid[k][v + 1] = 2;
                    queue.add(new Pair<Integer,Integer>(k, v + 1));                                             
                    freshOranges--;
                } 
                if(((k - 1) >= 0) && (grid[k - 1][v] == 1))
                {                    
                     
                    grid[k - 1][v] = 2;
                    queue.add(new Pair<Integer,Integer>(k - 1, v));
                    freshOranges--;
                } 
                if(((v - 1) >= 0) && (grid[k][v - 1] == 1))
                {            
                    grid[k][v - 1] = 2;
                    queue.add(new Pair<Integer,Integer>(k, v - 1));
                    freshOranges--;
                } 
            }
            if(queue.size() > 0)
                count++;
            
        }                
        return freshOranges == 0?count : -1;
    }   
}

