import java.util.*;
import java.lang.*;

public class NumIslands{
    
    public int numIslands(char[][] inp)
    {
        int count = 0;
        for(int i=0; i < inp.length; i++)
        {
            for(int j=0; j < inp.length; j++)    
            {
                if(inp[i][j] == '1')
                {
                    shrink(inp, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    public void shrink(char[][] inp, int i, int j)
    {
        if(i < 0 || j < 0 || i >= inp.length || j >= inp[i].length || inp[i][j] == '0')
        {
            return;
        }
        
        inp[i][j] = '0';
        
        shrink(inp, i+1, j);
        shrink(inp, i-1, j);
        shrink(inp, i, j+1);
        shrink(inp, i, j-1);
    }
    
    public static void main(String[] args)
    {
        char[][] m = 
        {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        
        System.out.println((new NumIslands()).numIslands(m));
    }
}
