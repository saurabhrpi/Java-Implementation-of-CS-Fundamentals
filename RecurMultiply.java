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
    
    // memoization
    
    int multiplyM(int a, int b)
    {
        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;
        int[] memo = new int[smaller + 1];
        return helperM(smaller, bigger, memo);
    }
    
    int helperM(int smaller, int bigger, int[] memo)
    {
        if(smaller == 0) return 0;
        if(smaller == 1) return bigger;
        if(memo[smaller] > 0) return memo[smaller]; // because of this we have to keep the size of array (smaller + 1).
        
        int s = smaller >> 1;
        int side1 = helperM(s, bigger, memo);
        int side2 = side1;
        
        if(smaller%2 == 1)
        {
            side2 = helperM(smaller - s, bigger, memo);
        }
        
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
    
    // optimal
    
    int multiplyO(int a, int b)
    {
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;
        return helperO(smaller, bigger);
    }
    
    int helperO(int smaller, int bigger)
    {
        if(smaller == 0) return 0;
        if(smaller == 1) return bigger;
        
        int s = smaller >> 1;
        int half = helperO(s, bigger);
        
        if(smaller % 2 == 0) return half * 2;
        else return half * 2 + bigger;
    }
    
    public static void main(String[] args)
    {
        RecurMultiply r = new RecurMultiply();
        System.out.println(r.minProduct(8,7));
    }
    
}
A
