// Implement the code to rank a number in a given stream of numbers
import java.lang.*;
import java.util.*;
import java.util.stream.Stream;

public class RankFromStream{
    
    ArrayList<Integer> stream;
    
    RankFromStream()
    {
        stream = new ArrayList<Integer>();
    }
    
    public void track(int x)
    {
        stream.add(x);   
    }
    
    public Integer getRankOfNumber(int x)
    {
        
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
    }
}
