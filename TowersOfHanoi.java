import java.util.*;
import java.lang.*;
import java.io.*;


public class Tower{
    
    Stack<Integer> disks;
    int index; //position
    
    Tower(int n)
    {
        disks = new Stack<Integer>();
        index = n;
    }
    
    void add(int d)
    {
        if(!disks.empty() && disks.peek() <= d)
        {
            System.out.println("Error");
            return;
        }
        disks.push(d);
    }
    
    void moveDiskTo(Tower t)
    {
        t.add(disks.pop());
    }
    
    void moveDisks(int n, Tower destination, Tower buffer)
    {
        if(n > 0)
        {
            moveDisks(n - 1, buffer, destination);
            moveDiskTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
    
    public static void main(String[] args)
    {
        int n = 3;
        
        Tower[] t = new Tower[n];
        
        for(int i = 0; i < n; i++)
        {
            t[i] = new Tower(i);
        }
        
        for(int i = 3; i > 0; i--)
        {
            t[0].add(i);
        }
        
        t[0].add(2);// should throw error
        
        t[0].moveDisks(n, t[2], t[1]);
        
        for(int j = 0; j < n ; j++)
        {
            System.out.println(t[2].disks.pop());
        }
    }
    
}
