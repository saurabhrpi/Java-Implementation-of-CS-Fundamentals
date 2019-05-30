import java.util.*;
import java.lang.*;
import java.io.*;

// Assuming that given integers are signed 32-bit (1 bit as sign, 31 for value).
// A bit vector is an array of type byte.
// Each index has 8 bits, every bit represents an integer.
// Total size of bit vector will be ((2^31) / 8) or 2^28 becuz every index can hold upto 8 integers.
public class MissingInt{
    
    public void findOpenNumber() throws FileNotFoundException
    {
        // (MAX_VALUE + 1) is negative if stored as an int 
        // that's why cast to long.
        // 1 is added since MAX_VALUE is 2^32 - 1.
        // and so that we don't fall short of the required 4 billion integers by 1.
        
        long numberOfInts = (long)(Integer.MAX_VALUE) + 1; 
        
        // array of type byte can take size of type int
        // One byte here represents one byte in memory.
        byte[] bitfield = new byte[(int)(numberOfInts/8)]; 
        String fileName =   " ";
        Scanner in = new Scanner(new FileReader(fileName));
        while(in.hasNextInt())
        {
            int n = in.nextInt();
            
            // we're going to use n%8 to find that unique bit of an integer 
            // and set it to 1, starting from the LSB (rightmost one).
            bitfield[n/8] |= 1 << (n%8);  
        }
    
        // we AND every bit of an index with 1, one by one and check if it's zero.
        // The first bit that returns 0 is our answer.
        for(int i=0; i < bitfield.length; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if((bitfield[i] & (1 << j)) == 0)
                {
                    System.out.println(i*8 + j);
                    return;
                }
            }
        }
    }
    
    // Follow up : For 10 MB of memory and 1 billion unique integers
    
    int findMissingNumber(String fileName) throws FileNotFoundException{
        
        // All 2 billion integers will need to be represented even though the given count is 1 billion.  
        
        // rangeSize will be equal to the number of integers an index can represent.
        // Every bit will uniquely represent an integer.
        int rangeSize = (1 << 20); // 2^17 bytes
        
        int[] blocks = getCountPerBlock(fileName, rangeSize);
    }
    
    public static void main(String[] args)
    {
        
    }
}
