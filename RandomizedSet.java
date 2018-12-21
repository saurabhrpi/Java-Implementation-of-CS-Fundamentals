import java.util.*;
import java.lang.*;

public class RandomizedSet{
    
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> numLocs;
    Random rand = null;
    
    public RandomizedSet()
    {
        nums = new ArrayList<Integer>();
        numLocs = new HashMap<Integer, Integer>();
        rand = new Random();    
    }
    
    public boolean insert(int num)
    {
        if(numLocs.containsKey(num))
        {
            return false;
        }
        
        numLocs.put(num, nums.size());
        nums.add(num);
        return true;
    }
    
    public boolean remove(int num)
    {
        if(!numLocs.containsKey(num))
        {
            return false;
        }
        
        int loc = numLocs.get(num);
        if(loc < nums.size() - 1)
        {
            int lastNum = nums.get(nums.size() - 1);
            nums.set(loc, lastNum);
            numLocs.put(lastNum, loc);
        }
        numLocs.remove(num);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    public int getRandom()
    {
        return nums.get(rand.nextInt(nums.size()));
    }
    
    public static void main(String[] args)
    {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));
        System.out.println(r.remove(2));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.remove(1));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
    }
}
