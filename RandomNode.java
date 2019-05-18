import java.util.*;
import java.lang.*;

public class TreeNode {
    
    int data;
    int size = 0;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data)
    {
        this.data = data;
        size = 1;
    }
    
    // The only improvement over the previous approach is the reduced
    // number of Random() calls.
    
    public TreeNode getRandomNode()
    {
        Random random = new Random();
        int i = random.nextInt(size);
        return getIthNode(i);
    }
    
    public TreeNode getIthNode(int i)
    {
        int lSize = left == null? 0 : left.size;
        if(i < lSize)
        {
            return left.getIthNode(i);
        }
        else if(i == lSize)
        {
            return this;
        }
        else
        {
            return right.getIthNode(i - (left.size + 1));
        }
    }
    
    public void insertInOrder(int d)
    {
        if(d <= data)
        {
            if(left == null)
            {
                left = new TreeNode(d);
            }
            else
            {
                left.insertInOrder(d);
            }
        }
        else{
            if(right == null)
            {
                right = new TreeNode(d);
            }
            else
            {
                right.insertInOrder(d);
            }
        }
        size++;
    }
    
    public TreeNode find(int d)
    {
        if(d == data)
        {
            return this;
        }
        else if(d < data)
        {
            return left == null ? null : left.find(d);
        }
        else
        {
            return right == null ? null : right.find(d);
        }
        
    }
    
    public static void main(String[] args)
    {
        
    }
}
