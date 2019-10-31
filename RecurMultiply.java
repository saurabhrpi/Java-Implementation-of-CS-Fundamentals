import java.util.*;
import java.lang.*;
import java.io.*;


public class RecurMultiply{
    
    int minProduct(int a, int b)
    {
        int bigger = a < b? b : a;
        int smaller = a < b? a : b;
        return minProductHelper(smaller, bigger);
    }
    
    int minProductHelper(int smaller, int bigger)
    {
        if(smaller == 0) return 0;
        if(smaller == 1) return bigger;
        
        int s = smaller >> 1;
        
        System.out.println("Before minProd : smaller " + smaller);
        System.out.println("Before minProd : s " + s);
        
        // calling minProduct instead of minProductHelper will ensure whichever is bigger stays untouched.
        int side1 = minProduct(s, bigger);
        
        System.out.println("side1 " + side1);
        System.out.println("After minProd : smaller " + smaller);
        System.out.println("After minProd : s " + s);
        
        // If smaller is even, side 2 will be same as side1, in other words, answer will be bigger * 2.
        // To further clarify, for smaller == 1 bigger is already = bigger.For smaller == 2 it will double and so on for every even smaller.
        int side2 = side1;
        
        // In case of smaller = odd, we are basically counting from scratch.
        // smaller - s will return the correct even number which can then be used to find the side2.
        // In this case side2 will always be > side1. 
        if(smaller%2 == 1)
        {
            System.out.println("smaller - s " + (smaller - s));
        
            side2 = minProductHelper(smaller - s, bigger);
        
            System.out.println("side2 " + side2);
        }
        
        System.out.println("end: smaller " + smaller);
        System.out.println("end : s " + s);
        System.out.println("returning " + (side1 + side2));
        
        return side1 + side2;
    }
    
    public static void main(String[] args)
    {
        RecurMultiply r = new RecurMultiply();
        System.out.println(r.minProduct(8,7));
    }
    
}
