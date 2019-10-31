import java.util.*;
import java.lang.*;
import java.io.*;


public class RecurMultiply{
    
    // choose which is smaller
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
        
        int s = smaller >> 1; // same as halving the number of squares
        
        //System.out.println("Before minProd : smaller " + smaller);
        //System.out.println("Before minProd : s " + s);
        
        int side1 = minProductHelper(s, bigger);
        
        //System.out.println("side1 " + side1);
        //System.out.println("After minProd : smaller " + smaller);
        //System.out.println("After minProd : s " + s);
        
        int side2 = side1;  // then double it
        
        if (smaller%2 == 1)  // if not even, make the number even by deducting the remainder 
        {
            //System.out.println("smaller - s " + (smaller - s));
            
            // Trivia : Number of call stacks generated will be log(smaller - s) + 1. 
            side2 = minProductHelper(smaller - s, bigger);// no need to call the multiply as we already know which is smaller.
        
            //System.out.println("side2 " + side2);
        }
        
        //System.out.println("end: smaller " + smaller);
        //System.out.println("end : s " + s);
        //System.out.println("returning " + (side1 + side2));
        
        return side1 + side2;
    }
    
    public static void main(String[] args)
    {
        RecurMultiply r = new RecurMultiply();
        System.out.println(r.minProduct(8,7));
    }
    
}
A
