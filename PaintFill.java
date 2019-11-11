import java.util.*;
import java.lang.*;
import java.io.*;

public class PaintFill{
    
    enum Color {Black, White, Red, Yellow, Green}
    
    boolean paintFill(Color[][] screen, int r, int c, Color ncolor)
    {
        if(screen[r][c] == ncolor) 
            return false;
        return paintFill(screen, r, c, screen[r][c], ncolor);
    }
    
    boolean paintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor)
    {
        if(r < 0 || r > screen.length || c < 0 || c > screen[0].length) 
            return false;
        
        // DFS
        // A pattern similar to go up, move to left, go down, move to left, go up and so on will be created. 
        
        if(screen[r][c] == ocolor)
        {
            screen[r][c] = ncolor;
            paintFill(screen, r - 1, c, ocolor, ncolor);
            paintFill(screen, r + 1, c, ocolor, ncolor);
            paintFill(screen, r, c - 1, ocolor, ncolor);
            paintFill(screen, r, c + 1, ocolor, ncolor);
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        
    }
}   
