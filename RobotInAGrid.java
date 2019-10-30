import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
    int row, col;
    
    Point(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }
        
        if(!(o instanceof Point))
        {
            return false;
        }
        
        Point p = (Point) o;
        
        return ((p.row == this.row) && (p.col == this.col));
    }
}

// The maze is in the form of cells, not coordinates.


public class RobotInAGrid{
    
    // naive
    // Runtime : 2 ^ (row + col).
    
    ArrayList<Point> getPathN(boolean[][] maze)
    {
        if(maze == null || maze.length == 0 ) return  null;
        
        ArrayList<Point> path = new ArrayList<Point>();
        if(getPathN(maze, maze.length - 1, maze[0].length - 1, path)) // send the row, col of destination cell. 
        {
            return path;
        }
        return null;
    }
    
    
    boolean getPathN(boolean[][] maze, int row, int col, ArrayList<Point> path)
    {
        // check if this cell exists or is accessible.
        if(row < 0 || col < 0 || !maze[row][col])
        {
            return false;
        }
        
        boolean atOrigin = (row == 0) && (col == 0);  //perhaps the reason we've not sent origin as part
                                                      // of func args is we don't have to. We can just check
                                                      // it inside.
        
        // the first expression acts as the base case
        // Keep going till you reach origin or a dead end (in which case it will return false).
        if(atOrigin || getPathN(maze, row, col - 1, path) || getPathN(maze, row - 1, col, path))
        {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        
        return false;
    }
    
    // optimal
    // Runtime : row * col
    
    ArrayList<Point> getPath(boolean[][] maze)
    {
        if(maze == null || maze.length == 0) return null;
        
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failed = new HashSet<Point>(); // "already visited" points list
        if(getPath(maze, maze.length, maze[0].length, path, failed))
        {
            return path;
        }
        return null;
    }
    
    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failed)
    {
        if(row < 0 || col < 0 || !maze[row][col])
        {
            return false;
        }
        
        Point p = new Point(row, col);
        
        if(failed.contains(p))
        {
            return false;
        }
        
        boolean atOrigin = (row == 0) && (col == 0);
        
        if(atOrigin || getPath(maze, row - 1, col, path, failed) || getPath(maze, row, col - 1, path, failed))
        {
            path.add(p);
            return true;
        }
        
        failed.add(p);//caching
        return false;
    }
    
    public static void main(String[] args)
    {

    }
    
}
