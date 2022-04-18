class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;        
        
        int[] ch = new int[256]; //can't use char[] since i'll be setting default val to -1.
        // Set default to -1 since an index starts from 0
        for(int k = 0; k < ch.length; k++)
            ch[k] = -1;
    
        int j = 0, i = 0; // i is the front pointer that keeps moving without any interruption.
        // j is the rear pointer that increases only when there is a repeat char found.
        int result = -1;
        for(; i < s.length();i++)
        {   
            System.out.println("*****************");
            if(ch[s.charAt(i)] > -1) // means this is a repeat char
            {             
                result = Math.max(result, i - j);             
                System.out.println("result " + result);
                int val = ch[s.charAt(i)]; // val is the last position set for this char in the int array
                System.out.println("val is " + val);
                System.out.println("j is " + j);
                // if the first index of the repeat char is < j, then do nothing and let it 
                // be set to the new index outside if.
                // Or if the last position exists inside the window (from j to i), then move the window.
                if(val >= j) 
                    j = val + 1;// we've to make sure j doesn't include the same char again.            
            }
            System.out.println("Setting ch[s.charAt(" + i + ")] to i = " + i);
            ch[s.charAt(i)] = i; // setting the char in the array to its latest position in string.            
        }        
        return Math.max((i - j), result); // for cases where non-repeating substring may consist of
        // last char.
    }
}
