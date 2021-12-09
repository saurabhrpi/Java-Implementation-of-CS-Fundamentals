class Solution {
// My implementation of modified version of given sol. Runs in O(n^2).    
    public int maxPoints(int[][] points) {
        if(points.length <= 2)
            return points.length;
        Double m = null;                
        Map<Double, Integer> slopeAndLines = new HashMap<>(); //Maps slope to number of points on it. Is Reset for each point.
        int max = 0; // tracks the slope with max points for a point
        int result = 0;// tracks final answer
        for(int i = 0; i < points.length - 1; i++)
        {           
            slopeAndLines.clear();
            for(int j = i + 1; j < points.length;j++)
            {                
                if(points[j][0] - points[i][0] != 0)
                {
                    m = ((double)(points[j][1] - points[i][1])/(points[j][0] - points[i][0]));            
                }  
                else
                {                    
                    m = null;// horizontal line; Saving it as null will ensure it won't be counted towards //other lines with slope = 1.                    
                }                
                if(m != null && m == -0.0) // issue with hashmap treating 0.0 and -0.0 as separate keys.
                    m = 0.0;
                
                if(!slopeAndLines.containsKey(m))
                    slopeAndLines.put(m, 2);
                else
                    slopeAndLines.put(m, slopeAndLines.get(m) + 1);
                int val = slopeAndLines.get(m);                
                if(max < val)
                    max = val;
            }
            if(result < max)
                result = max;
        }       
        return result;
    }    
}

// My AC implementation : n^3
/*
public int maxPoints(int[][] points) {
        if(points.length <= 2)
            return points.length;
        Double m = null, c = null;
        int count = 2;
        int prev = count;
        int j = 0;
        for(int i = 0; i < points.length - 1; i++)
        {
            //System.out.println("starting for i= " + i);
            for(int k = i + 1; k < points.length - 1; k ++) // couple forming iteration
            {
                if(points[k][0] - points[i][0] != 0)
                {
                    m = ((double)(points[k][1] - points[i][1])/(points[k][0] - points[i][0]));
                    c = ((double)(points[i][1]) - m*(points[i][0]));                        
                }   
                else
                {
                    c = 0.0;
                    m = 1.0;
                }
                //System.out.println("m & c are " + m + ", " + c);
                for(j = k + 1; j < points.length; j++)
                {                
                    //System.out.println("starting for j = " + j);
                    double slope = 0.0;
                    if(points[j][0] - points[i][0] != 0)
                    {
                        slope = ((double)(points[j][1] - points[i][1])/(points[j][0] - points[i][0]));
                        //System.out.println("slope " + slope);   
                    }                    
                    else
                    {
                        slope = 1.0;                        
                    }
                    if(m == slope)
                    {
                        double constant = 0.0;
                        if(points[j][0] - points[i][0] != 0)
                             constant = ((double)points[i][1] - m*(points[i][0]));                        
                        //System.out.println("constant " + constant);
                        if(c == constant)
                          count++;  
                        //System.out.println("count inside else is " + count);
                    }                     
                }
                if(count > prev)
                    prev = count;
                count = 2;
                m = null; 
                c = null;                
            }            
            //System.out.println("count " + count);
            if(count > prev)
                prev = count;
            count = 2;
            m = null; 
            c = null;
        }
        return prev;
    }
*/
