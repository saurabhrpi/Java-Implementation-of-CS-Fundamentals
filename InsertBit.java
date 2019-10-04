import java.util.*;
import java.lang.*;

public class MyClass {
    public static void main(String args[]) {
        MyClass m = new MyClass();
        System.out.println("res " + m.insert(5,173,4,2));
    }
    
    public int insert(int m, int n, int j, int i)
    {
        int updB = 1 << (j + 1);
        //int updB = 0;
        int offB = 0;
        
        for(int k = 0; k < n - j; k++)
        {
            if(k >= i && k < j + 1)
            {
                continue;
            }
            offB = offB | (1 << k);
            updB |= offB;
            System.out.println("updB " + updB);
        }
        
        //System.out.println("updB " + updB);
        
        m = m & updB;
        m = m | n;
        return m;
    }
}
