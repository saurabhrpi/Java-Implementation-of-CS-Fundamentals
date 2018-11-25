import java.util.*;
import java.lang.*;

class Coordinate implements Cloneable{
    
    int row;
    int column;
    
    public Coordinate(int r, int c)
    {
        row = r;
        column = c;
    }
    
    public boolean inBounds(int[][] matrix)
    {
        return row >= 0 && row <= matrix.length - 1 && column >= 0 && column <= matrix[0].length - 1;
    }
    
    public boolean isBefore(Coordinate p)
    {
        return row <= p.row && column <= p.column;
    }
    
    public Object clone()
    {
        return new Coordinate(row, column);
    }
    
    public void setToAverage(Coordinate x , Coordinate y)
    {
        row = (x.row + y.row) / 2;
        column = (x.column + y.column) / 2;
    }
}

public class SortedMatrix{
    
   public Coordinate findElement(int[][] matrix, int x)
   {
       return findElement(matrix, new Coordinate(0,0), new Coordinate(matrix.length - 1, matrix[0].length - 1), x);
   }
   
   public Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x)
   {
       if(!origin.inBounds(matrix) || !dest.inBounds(matrix))
       {
           return null;
       }
       
       if(matrix[origin.row][origin.column] == x)
       {
           return origin;
       }
       
       if(!origin.isBefore(dest))
       {
           return null;
       }
       
       Coordinate start = (Coordinate)origin.clone();
       int diagDist = Math.min(dest.row - start.row, dest.column - start.column);
       Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
       Coordinate p = new Coordinate(0,0);
       
       while(start.isBefore(end))
       {
           p.setToAverage(start, end);
           
           if(matrix[p.row][p.column] > x)
           {
               end.row = p.row - 1;
               end.column = p.column - 1;
           }
           else
           {
               start.row = p.row + 1;
               start.column = p.column + 1;
           }
       }
       
       return partitionAndSearch(matrix, start, origin, dest, x);
   }
   
   public Coordinate partitionAndSearch(int[][] matrix, Coordinate pivot, Coordinate origin, Coordinate dest, int x)
   {
       Coordinate loweLeftOrigin = new Coordinate(pivot.row, origin.column);
       Coordinate loweLeftDest = new Coordinate(dest.row, pivot.column - 1);
       Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
       Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
       
       Coordinate left = findElement(matrix, loweLeftOrigin, loweLeftDest, x);
       
       if(left == null)
       {
           return findElement(matrix, upperRightOrigin, upperRightDest, x);
       }
       
       return left;
   }

   public static void main(String[] args)
    {
        int[][] arr = { 
            {10, 17, 19,},
            {11, 18, 42,},
            {14, 27, 45,},
            {16, 35, 49,},
        };
        
        String str = "ball";
        
        SortedMatrix l = new SortedMatrix();
        
        Coordinate res = l.findElement(arr, 42);
        System.out.println("result = (" + res.row + ", " + res.column+ ")");
        //System.out.println(l.elementAt(70));
    }
}
