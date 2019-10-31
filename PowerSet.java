import java.util.*;
import java.lang.*;
import java.lang.Object;
import java.io.*;

public class PowerSet{
    
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
    {
        if(index == set.size())
        {
            ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
            sets.add(new ArrayList<Integer>());
            return sets;
        }
        ArrayList<ArrayList<Integer>> sets = getSubsets(set, index + 1);
        int item = set.get(index);

        // can't skip the line below cuz using allsubsets in the loop below will throw concurrentModificationException
        ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>(); 
                                                                           
        for(ArrayList<Integer> subset : allsubsets)
        {
            ArrayList<Integer> newsubset = new ArrayList<Integer>();
            newsubset.addAll(subset); // merge newsubset with subset
            newsubset.add(item);
            moresubsets.add(newsubset);
        }
        sets.addAll(moresubsets);
        return sets;
    }
    
    
    public static void main(String[] args)
    {
        PowerSet p = new PowerSet();
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        ArrayList<ArrayList<Integer>> sets = p.getSubsets(set, 0);
        System.out.println("size " + sets.size());
        System.out.println("**subsets**");
        for(ArrayList<Integer> subset : sets)
        {
            System.out.println("start of subset");
            //System.out.println("subset size " + subset.size());
            for(int i : subset)
            {
                System.out.println(i);
            }
        }
    }
}
