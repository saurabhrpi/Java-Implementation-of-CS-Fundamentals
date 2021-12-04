/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    // There are no equal elements in MountainArr on one side of peak. This is concluded based on 
    //bullet point 2 under "You may recall... " and the fact that we can access get() limited number of 
    //times.
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr == null || mountainArr.length() == 0)
            return -1;
        int peak = findPeakIndex(mountainArr);
        return findMinIndex(mountainArr, peak, target);
    }
    
    public int findMinIndex(MountainArray mountainArr, int peak, int target)
    {
        int left = 0, right = peak, res = -1;
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(mountainArr.get(mid) < target)
                left = mid + 1;
            else if(mountainArr.get(mid) > target)
                right = mid - 1;
            else 
                return mid;
        }
        left = peak; 
        right = mountainArr.length() - 1;
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(mountainArr.get(mid) > target)
                left = mid + 1;
            else if(mountainArr.get(mid) < target)
                right = mid - 1;
            else 
                return mid;
        }    
        return -1;
    }
    
    // Comment #1 : For line #62: To understand such corner cases, always take the case of two 
    //element array. So in that case,"everytime" we're moving left only till mid and hence at the end it 
    //will never be == right. And it will be an infinite loop. In order to exit the loop, we have to make 
    //sure left and right meet. Similar is the line of thinking for line 28 and line 30.
    public int findPeakIndex(MountainArray mountainArr)
    {
        int left = 0, right = mountainArr.length() - 1;
        int peak = 0;
        while(left < right) // loop shouldnt run for left == right since then it will run forever if mountainArr.get(mid) > mountainArr.get(mid + 1).
        {
            int mid = (left + right)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1))
            {
                left = mid + 1; 
                peak = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return peak;
    }
}
