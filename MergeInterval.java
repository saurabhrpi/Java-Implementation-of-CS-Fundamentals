class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer,List<Integer>> startToInd = new HashMap<>();// Tracking starts of elements using its index
        int[] starts = new int[intervals.length]; // to hold the first element of all tuples for sorting.
        
        // store first element's index as element may change positions after sorting.
        for(int i = 0; i < intervals.length; i++)
        {
            starts[i] = intervals[i][0];
            if(!startToInd.containsKey(intervals[i][0]))
            {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                startToInd.put(intervals[i][0],l);
            }
            else
            {
                // in case there are more than element with same value
                List<Integer> l = startToInd.get(intervals[i][0]);   
                l.add(i);
                startToInd.put(intervals[i][0],l);
            }                
        }
        Arrays.sort(starts);
        int[][] newIntervals = new int[intervals.length][2];
        for(int i = 0; i < newIntervals.length; i++)
        {            
            List<Integer> l = startToInd.get(starts[i]);
            for(int j = 0; j < l.size(); j++)
            {
                newIntervals[i][0] = starts[i];
                newIntervals[i][1] = intervals[l.get(j)][1];
                i++;
            }
            i--;
        }
        int ignore = 0;// count of the intervals in original array to be ignored for the final result.   
        
        for(int i = 0; i < newIntervals.length; i++)
        {           
            if(i < newIntervals.length - 1)
            {   
                int nextStart = newIntervals[i + 1][0];                            
                // merge the two consecutive intervals.
                if(newIntervals[i][0] <= nextStart && nextStart <= newIntervals[i][1])
                {
                    if(newIntervals[i + 1][1] < newIntervals[i][1])
                        newIntervals[i + 1][1] = newIntervals[i][1];
                    newIntervals[i + 1][0] = newIntervals[i][0];
                    newIntervals[i][0] = -1;
                    newIntervals[i][1] = -1;   
                    ignore++;
                }                
            }            
        }
        int[][] result = new int[newIntervals.length - ignore][2];
        int j = 0;
        for(int i = 0; i < newIntervals.length; i++)
        {
            if(newIntervals[i][0] != -1)
            {
                result[j][0] = newIntervals[i][0];   
                result[j][1] = newIntervals[i][1];
                j++;
            }                
        }
        return result;
    }
}
