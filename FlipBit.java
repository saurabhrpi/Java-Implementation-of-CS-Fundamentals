import java.util.*;
import java.lang.*;


public class FlipBit{
    
    public void generateAlternatingSequences(int num, ArrayList<Integer> sequences)
    {
        int counter = 0;
        int searchingFor = 0;
        
        while(num > 0)
        {
            if((num & 1) != searchingFor)
            {
                sequences.add(counter);
                searchingFor = num & 1;
                counter = 0; 
            }
            counter++; // this index still has to be counted
            num >>>= 1;   
        }
        sequences.add(counter);
    }
    
    public int findLongestSequence(ArrayList<Integer> sequences)
    {
        int LSeq = 0;
        int RSeq = 0;
        int maxSeq = 1; // assuming the min value sent as num is 1
        for(int i=0; i < sequences.size(); i += 2)
        {
            int zeroSeq = 0;
            if()
        }
    }
    
    public int flip(int num)
    {
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        generateAlternatingSequences(num, sequences);
        
    }
    
    public static void main(String args[]) {
      
    }
}
