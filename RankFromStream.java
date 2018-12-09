import java.lang.*;
import java.util.*;
import java.util.stream.Stream;

class RankNode{
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;
    public RankNode(int d)
    {
        data = d;
    }
    
    public void insert(int d)
    {
        if(d <= data)
        {
            if(left != null)
            {
                left.insert(d);
            }
            else
            {
                left = new RankNode(d);
            }
        }
        else
        {
            if(right != null)
            {
                right.insert(d);
            }
            else
            {
                right = new RankNode(d);
            }
        }
    }
    
    public int getRank(int d)
    {
        if(d == data)
        {
            return left_size;
        }
        else if( d < data )
        {
            if(left == null)
            {
                return -1;
            }
            else
            {
                return left.getRank(d);
            }
        }
        else
        {
            int right_rank = right == null? -1 : right.getRank(d);
            if(right_rank == -1)
            {
                return -1;
            }
            else
            {
                left_size + 1 + right_rank;
            }
        }
    }
}

public class RankFromStream{
    
    RankNode root = null;
    
    public void track(int num)
    {
        if(root == null)
        {
            root = new RankNode(num);
        }
        else
        {
            root.insert(num);
        }
    }
    
    public int getRankOfNumber(int number)
    {
        return root.getRank(number);
    }
    
    public static void main(String[] args)
    {
        int[] arr = {
          11,
          1,
          9,
          11,
          18,
          9,
          1,
          6
        };
        
        RankFromStream rfs = new RankFromStream();
        
        for(int i=0; i < arr.length; i++)
        {
            rfs.track(arr[i]);
            System.out.println(rfs.getRankOfNumber(1));
        }
    }
}
