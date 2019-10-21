import java.util.*;
import java.lang.*;


public class PairWiseSwap{
    
    public int swapBits(int num)
    {
        return ((num >>> (0xaaaaaaaa)) | ((num << (0x55555555)))); // logical right shift will ensure the 2nd last bit is preserved in the result.
    }
    
    public static void main(String args[]) 
    {
        PairWiseSwap c = new PairWiseSwap();
    }
}
