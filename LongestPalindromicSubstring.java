import java.util.Stack;

class Solution {
    
    public String longestPalindrome(String s) {
     //return usingExpandAroundAnIndex(s); // n^2
        //return mylongestPalindrome(s); //n^3
        return manachersAlgo(s); // n
}
    
    //https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
    public String manachersAlgo(String s)
    {
        char[] T = new char[s.length()*2 + 1];
        int[] Len = new int[T.length];
        int p0 = 0, p = 0; // p is the index of last character of the current longest palindrome.
        for(int i = 0; i < s.length(); i++){
            T[2*i+1] = s.charAt(i);
        }
        
        for(int i = 0; i < T.length; i++)
            System.out.println("T[i]: " + T[i]);
        
        Len[0] = 1; // Length of palindrome from the center to one end (incl. center)
        for(int i = 1; i < Len.length; i++){
            System.out.println("start of iteration " + i);
            System.out.println("i " + i);
            System.out.println("p " + p);
            System.out.println("p0 " + p0);
            // if index i is outside the bounds of longest palindrome so far, set Len[i] to 1. Else
            // set Len[i] = minimum of the (Len of its mirror image character or its distance from the palindrome's end + 1).            
            Len[i] = i < p ?  Math.min(Len[2*p0 - i], p-i+1) : 1; 
            System.out.println("Len[i] " + Len[i]);// Length of palindrome centerd at i
            
            // Before passing variables as paddedString 's indices, checking for their validity. And then,
            // checking if there is some palindrome of length > 1 centered at index i.
            while(i-Len[i] >= 0 && i+Len[i] < T.length && T[i-Len[i]] == T[i+Len[i]])             
            {
                System.out.println("inside while");
                Len[i]++; // increase and then check again lower and higher indices for palindrome
            }
            // p-p0+1 below cuz that is same as Len[i] which is one half of palindrome incl. center.
            if (Len[i] > p-p0+1) { // if the palindrome at index i is > longest Palindrome so far
                p0 = i;  // index of center of longest palindrome so far
                p = i + Len[i] - 1; // length of the longest palindrome so far (reducing 1 due to double counting). Len[i] already includes length of palindrom from i onwards. Hence just adding i - 1 to it.
            }
            System.out.println("end of iteration " + i);
        }
        System.out.println("returning " + s.substring((2*p0-p)/2, p/2));
        return s.substring((2*p0-p)/2, p/2); // divide by 2 as it's a padded string
    }

    
    public String myManachersAlgo(String s)
    {
        if(s == null || s.length() == 0) return "";
        
        char[] paddedString = new char[2*s.length() + 1];
        int j = 0;
        for(int i=0; i < paddedString.length; i++)
        {
            if(i%2 == 0)
                paddedString[i] = ' ';
            else
            {
                paddedString[i] = s.charAt(i/2);                   
            }                
        }
        
        int[] LPS = new int[2*s.length() + 1];
        LPS[0] = 1;
        
        int centerOfLPSSoFar = 0, lenOfLPSSoFar = 0;
        for(int i = 1; i < LPS.length; i++)
        {
            LPS[i] = i < lenOfLPSSoFar ? Math.min(LPS[2*centerOfLPSSoFar - i], lenOfLPSSoFar - i + 1) : 1;
            
            
            while(i - LPS[i] >=0 && i + LPS[i] < paddedString.length && paddedString[i + LPS[i]] == paddedString[i - LPS[i]]) 
            {
                LPS[i]++;
            }
            if(LPS[i] > centerOfLPSSoFar - lenOfLPSSoFar + 1)
            {
                lenOfLPSSoFar = i + LPS[i] - 1;
                centerOfLPSSoFar = i;
            }
        }
        return s.substring((2*centerOfLPSSoFar - lenOfLPSSoFar)/2,lenOfLPSSoFar/2);
    }    
        
    public String usingExpandAroundAnIndex(String s)
    {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //System.out.println("For len1 passing: " + i + " " + i);
            int len1 = expandAroundCenter(s, i, i); // i as center for odd length substrings 
            //System.out.println("For len2 passing: " + i + " " + (i+1));
            int len2 = expandAroundCenter(s, i, i + 1);// i as center for even length substrings
            int len = Math.max(len1, len2);// max helps work in cases where no palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2; // cuz for even substring we want to go one less character backwards from i compared to going forwards from i (end).
                end = i + len / 2;
                //System.out.println("start: " + start);
                //System.out.println("end: " + end);
            }
        }
        //System.out.println("returning " + s.substring(start, end + 1)); 
        return s.substring(start, end + 1);
    }

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    //System.out.println("R - L - 1 " + (R - L - 1));
    return R - L - 1; // cuz both have moved one extra position. Returns 1 if no palindrome found. 
}
 
    //**********************My Impl***************************************
    
    public String mylongestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        
        String res = "";
        for(int i=0; i < s.length() - 1; i++)
        {
            for(int j = i + 1; j < s.length(); j++)
            {
                String check = s.substring(i,j + 1);
                if(isPalindromeConstantSpace(check))
                {
                    if(res.length() < check.length())
                        res = check;
                }
            }
        }
        if(res.equals(""))
            res = "" + s.charAt(0) + "";
        return res;
    }
    
    // Faster than stack in avg and best case
    public boolean isPalindromeConstantSpace(String s)
    {
        int leftP = 0, rightP = s.length() - 1;
        while(leftP < rightP)
        {
            if(s.charAt(leftP) != s.charAt(rightP))
                return false;
            leftP++;
            rightP--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s)
    {
        if(s.length() == 1) return true;
        
        Stack<Character> stck = new Stack<Character>();
        int startFrom = -1;
        int quo = s.length()/2;
        if(s.length()%2 == 1)
        {
            startFrom = quo + 1;
        }
        else
        {
            startFrom = quo;
        }        
        
        for(int i=0; i < quo; i++)
        {
            stck.push(s.charAt(i));
        }
        for(int i = startFrom; i < s.length(); i++)
        {
            if(s.charAt(i) != stck.pop())
                return false;
        }
        return true;
    }
    
}
