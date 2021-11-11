class Solution {
    public boolean isSubsequence(String s, String t) {
        //return myImplementation(s,t);
        //return cleanerImplementation(s,t);        
        //return recursionForLearning(s,t, s.length(), t.length(), 0,0);        
        return dpForLearning(s,t);
    }
    
    public boolean dpForLearning(String s, String t)
    {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= t.length(); j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        if(dp[s.length()][t.length()] == s.length())
            return true;
        return false;
    }
    
    public boolean recursionForLearning(String s, String t, int sLength, int tLength, int sIndex, int tIndex)
    {
        if(sIndex == sLength)
            return true;
        if(tIndex == tLength)
            return false;
        if(s.charAt(sIndex) == t.charAt(tIndex)) sIndex++;
        return recursionForLearning(s,t,sLength,tLength,sIndex,tIndex+1);
    }
    
    public boolean cleanerImplementation(String s, String t)
    {
        if(s == null || t == null)
            return false;
        if(s.length() > t.length())
            return false;
        if(s.isEmpty()) return true;
        
        int i = 0, j=0;
        while(i < s.length() && j < t.length())
        {
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        if(i == s.length()) return true;
        return false;
    }
    
    public boolean myImplementation(String s , String t)
    {
        if(s == null || t == null)
            return false;
        if(s.length() > t.length())
            return false;
        int j = 0, i = 0;
        while(i < s.length())
        {            
            while(j < t.length())
            {                
                if(t.charAt(j)==s.charAt(i))
                {    
                    j++;
                    i++;
                    break;   
                }
                j++;                
            }            
            if(j >= t.length())
               break;            
        }
        
        if(i <= s.length() - 1) return false;        
        return true;
    }
}
