import java.util.*;
import java.lang.*;

public class MyClass {
    public static void main(String args[]) {
      
      System.out.println("Sum of x+y = " + z);
    }
    
    public int insert(int m, int n, int j, int i)
    {
        int updB = 1 << (j + 1);
        int offB = 0;

        for(int k = 0; k < n - j; k++)
        {
            if(k == i)
            {
                k = j + 1;
            }
            updB = updB | (1 << k);
        }
    }
}
