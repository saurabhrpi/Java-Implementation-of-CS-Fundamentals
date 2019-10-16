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
        int thisSeq = 0;
        for(int i=0; i < sequences.size(); i += 2)
        {
            int zeroSeq = sequences.get(i);
            if(zeroSeq == 1)
            {
                LSeq = i - 1 >= 0 ? sequences.get(i - 1) : 0;
                RSeq = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;
                thisSeq = LSeq + RSeq + 1;
            }
            else if(zeroSeq != 1)
            {
                LSeq = i - 1 >= 0 ? sequences.get(i - 1) : 0;
                RSeq = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;
                thisSeq = Math.max(LSeq, RSeq) + 1;
            }
            /*
            book considers case when zeroSeq == 0. Why?
            */
            maxSeq = Math.max(maxSeq, thisSeq);
        }
        return maxSeq;
    }
    
    public int flip(int num)
    {
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        generateAlternatingSequences(num, sequences);
        return findLongestSequence(sequences);
    }
    
    public static void main(String args[]) {
        FlipBit f = new FlipBit();
        System.out.println(f.flip(86)); //1010110
    }
}

// O(b) : Runtime & memory where b is the number of bits in the number
