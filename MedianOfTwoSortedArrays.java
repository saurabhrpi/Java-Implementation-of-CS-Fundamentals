import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {     
        // Intuition : When left sides after the cut of each array is smaller than the other array's right side, 
        // that means we've reached the correct position in our array (small array is the one we'll search in).
        
        //imagine two such arrays as below with # representing a pad that makes sure we deal with
        // odd even length scenarios using 1 solution:        
        // # 1 # 3  # 4  # 7  # 12 # 15 # (len = 13)
        // # 7 # 10 # 16 # 29 # (len = 9)
        // Cut can be land either on a number or a #. For e.g. let's say two cuts are c1 and c2.
        // If c2 = 4 (index) which is # between 4 and 15, then in order to have equal halves, c1 must //be 10-4 = 6 ( # between 7 and 16). 10 becuz that's the total number of elements of two arrays. Then //the Left half has (10,29, 7, 19, 4) while right half has (15,7,1,3,16). Similarly, if c2 = 5 //(index), then it will result in both left and right halves having 15. C1 will be 10-5 = 5, which //means both left and right halves will have 7. This will result in two equal halves as //(10,29,7,19,4,15) and (15,7,1,3, 16,7).
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        // we want to iterate over the shorter one as we'll have to iterate over fewer elements.
        if(len1 < len2) 
        {
            return findMedianSortedArrays(nums2, nums1);
        }        
        int low = 0, high = 2*(len2);// index values incl. #
        int mid2 = 0, mid1 = 0;
        while(low <= high)
        {
           System.out.println("*************"); 
           mid2 = (low + high)/2;
           System.out.println("mid2 is " + mid2);
           mid1 = len1 + len2 - mid2;
           System.out.println("mid1 is " + mid1); 
           //Integer.Min_VAlUE and Max_Value represent first and last # on the ends of combined //arrays cuz we can no longer push the left beyond first or right beyond last #. These are expected //possible scenarios for both hence both are assigned min and max respectively.
           int L2 = (mid2 == 0? Integer.MIN_VALUE:nums2[(mid2-1)/2]);         
           int R2 = (mid2 == 2*len2? Integer.MAX_VALUE:nums2[(mid2)/2]);                             
           int L1 = (mid1 == 0)? Integer.MIN_VALUE:nums1[(mid1-1)/2];         
           int R1 = (mid1 == 2*len1)? Integer.MAX_VALUE:nums1[(mid1)/2];      
           System.out.println("L2 " + L2);
           System.out.println("R2 " + R2);
           System.out.println("L1 " + L1);
           System.out.println("R1 " + R1);
           // # 1 # 3  # 4  # 7  # 12 # 15 # (len = 13)
           // # 7 # 10 # 16 # 29 # (len = 9) 
           // Which ever array's left side is bigger, move that array's mid towards left.
           if(L2 > R1) high = mid2 - 1; // search in the segment lower than L2.           
           else if(L1 > R2) low = mid2 + 1; // so that mid1 moves in opposite direction.
           else return (double)(Math.max(L1,L2) + Math.min(R1,R2))/2; // cuz median will be contributed by last element on left and first element on right side.
           System.out.println("high is " + high); 
           System.out.println("low is " + low);
        }
        return -1;
    }
}
