import java.util.*;
import java.lang.*;

class Interval{
    int start;
    int end;
    
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

public class SortInterval{
        
        public List<Interval> merge(List<Interval> intervals)
        {
            if(intervals.size() <= 1)
            {
                return intervals;
            }
            
            int n = intervals.size();
            int[] starts = new int[n];
            int[] ends = new int[n];
            
            for(int i=0; i < n; i++)
            {
                starts[i] = intervals.get(i).start;
                ends[i] = intervals.get(i).end;
            }
            
            Arrays.sort(starts);
            Arrays.sort(ends);
            
            List<Interval> res = new ArrayList<Interval>();
            
            for(int i=0, j = 0; i< n; i++)
            {
                if(i == n - 1 || starts[i+1] > ends[i])
                {
                    res.add(new Interval(starts[j], ends[i]));
                    j = i + 1;
                }
            }
            
            return res;
        }
        
        public static void main(String[] args)
        {
            Interval i1 = new Interval(1,3);
            Interval i2 = new Interval(2,6);
            Interval i3 = new Interval(8,10);
            Interval i4 = new Interval(15,18);
            
            List<Interval> arr = new ArrayList<Interval>();
            arr.add(i1);
            arr.add(i2);
            arr.add(i3);
            arr.add(i4);
            
            List<Interval> res = (new SortInterval()).merge(arr);
            
            for(Interval i : res)
            {
                System.out.println("start " + i.start + " and end " + i.end);
            }
            
        }
}
