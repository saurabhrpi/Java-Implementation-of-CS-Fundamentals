public class Zeroes{
    
    public void makeZeroInPlace(int[][] m)
    {
        if(m != null && m.length > 0)
        {
            boolean rowHasZero = false;
            boolean colHasZero = false;
            
            for(int i=0; i < m[0].length ; i++)
            {
                if(m[0][i] == 0)
                {
                    rowHasZero = true;
                    break;
                }
            }
            
            for(int i=0; i < m.length ; i++)
            {
                if(m[i][0] == 0)
                {
                    colHasZero = true;
                    break;
                }
            }
            
            for(int i=1; i < m.length; i++)
            {
                for(int j=1; j < m[0].length; j++)
                {
                    if(m[i][j] == 0)
                    {
                        m[i][0] = 0;
                        m[0][j] = 0;
                    }
                }
            }
            
            for(int i = 1; i < m.length ; i++)
            {
                if(m[i][0] == 0)
                {
                    for(int k = 0; k < m.length; k++)
                    {
                        m[i][k] = 0;
                    }
                }
            }
            
            for(int i = 1; i < m[0].length ; i++)
            {
                if(m[0][i] == 0)
                {
                    for(int k = 0; k < m.length; k++)
                    {
                        m[k][i] = 0;
                    }
                }
            }
            
            if(rowHasZero)
            {
                for(int i = 0; i < m.length ; i++)
                {
                    m[0][i] = 0;
                }
            }
            
            if(colHasZero)
            {
                for(int i = 0; i < m.length ; i++)
                {
                    m[i][0] = 0;
                }
            }
        }
    }
    
    public void makeZero(int[][] m)
    {
        if(m != null && m.length > 0)
        {
            boolean[] rows = new boolean[m.length];
            boolean[] cols = new boolean[m[0].length];
            
            for(int i=0; i < m.length ; i++)
            {
                for(int j=0; j < m[0].length; j++)
                {
                    if(m[i][j] == 0)
                    {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
            
            for(int i=0; i < rows.length ; i++)
            {
                if(rows[i])
                {
                    for(int j=0; j < cols.length ; j++)
                    {
                        m[i][j] = 0;   
                    }
                }
            }
            
            for(int i=0; i < cols.length ; i++)
            {
                if(cols[i])
                {
                    for(int j=0; j < rows.length ; j++)
                    {
                        m[j][i] = 0;   
                    }
                }
            }
        }
    }
    
    public static void main(String args[]) {
        int[][] m = {
            {110, 10, 567},
            {10,0, 30},
            {90,1000, 176}
        };
        
        for(int i=0; i < m.length ; i++)
        {
            for(int j=0; j < m[0].length; j++)
            {
                System.out.println(m[i][j]);
            }
        } 
        
              System.out.println("************************");
        
        Zeroes z = new Zeroes();
        
        z.makeZeroInPlace(m);
        for(int i=0; i < m.length ; i++)
        {
            for(int j=0; j < m[0].length; j++)
            {
                System.out.println(m[i][j]);
            }
        }   
    }
}
