class Solution {
    public int numJewelsInStones(String J, String S) {
        //could have used boolean array as well
        int[] jewels = new int[256];
        
        for(char c : J.toCharArray())
        {
            jewels[c] = 1;
        }
        
        int res = 0;
        for(char c : S.toCharArray())
        {
            if(jewels[c] == 1)
            {
               res++; 
            }
        }
        return res;
    }
}
