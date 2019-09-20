class Solution {
    public String removeVowels(String S) {
        if(S == null || S.length() == 0)
        {
            return "";
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i < S.length(); i++)
        {
            if(!isAVowel(S.charAt(i)))
            {
                sb.append(S.charAt(i));
            }
        }
        
        if(sb.length() > 0)
            return sb.toString();
        
        return new String("");
    }
    
    public boolean isAVowel(char x)
    {
        if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
        {
            return true;
        }
        return false;
    }
}
