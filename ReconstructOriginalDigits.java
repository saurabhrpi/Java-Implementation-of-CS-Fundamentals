// Leetcode problem # 423
class Solution {   
  public String originalDigits(String s) {  
    //  O(N). Faster than 60%.
    char[] ch = new char[26];
    for(int i = 0; i < s.length(); i++)
    {
        ch[s.charAt(i) - 'a']++;
    }
    
    int[] out = new int[10];
    for(int i = 0 ; i < ch.length; i++)
    {
        out[0] = ch['z' - 'a'];
        out[2] = ch['w' - 'a'];
        out[4] = ch['u' - 'a'];
        out[6] = ch['x' - 'a'];
        out[8] = ch['g' - 'a'];
        out[3] = ch['h' - 'a'] - out[8]; // cuz h appears in 8 also. 
        out[5] = ch['f' - 'a'] - out[4];
        out[7] = ch['v' - 'a'] - out[5];
        out[1] = ch['o' - 'a'] - out[0] - out[2] - out[4];
        out[9] = (ch['n' - 'a'] - out[1] - out[7])/2;// n comes twice in 9.    
    }
    StringBuilder res = new StringBuilder();      
    for(int i = 0; i < out.length; i++)
    {
        for(int j = 0; j < out[i]; j++)
            res.append(Integer.toString(i));
    }
    return res.toString();    
  }  
    /*
    // O(N). Faster than 10%.
    public String originalDigits(String s) {
        //zero,one,two,three,four,five,six,seven,eight,nine
       String[] sb = new String[10];
        sb[0] = "zero";
        sb[1] = "one";
        sb[2] = "two";
        sb[3] = "three";
        sb[4] = "four";
        sb[5] = "five";
        sb[6] = "six";
        sb[7] = "seven";
        sb[8] = "eight";
        sb[9] = "nine";        
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {        
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);             
        }
        
        StringBuilder res = new StringBuilder();    
        int[] arr = new int[10];
        while(!map.isEmpty())        
        {
            String str = "";
            int i = 0;
            if(map.containsKey('z'))            
            {
                 str = sb[0];        
                 i = 0;
            }         
            else if(map.containsKey('w'))            
            {
                str = sb[2];   
                i = 2;
            }                             
            else if(map.containsKey('u'))            
            {
                str = sb[4];
                i = 4;
            }                                            
            else if(map.containsKey('x'))
            {
                str = sb[6];  
                i = 6;
            }                                                     
            else if(map.containsKey('g'))
            {
                str = sb[8];       
                i = 8;
            }        
            else if(map.containsKey('h'))
            {
                str = sb[3];   
                i = 3;
            }            
            else if(map.containsKey('f'))
            {
                str = sb[5];
                i = 5;
            }            
            else if(map.containsKey('v'))
            {
                str = sb[7];   
                i = 7;
            }            
            else if(map.containsKey('o'))
            {
                 str = sb[1];       
                 i = 1;
            }            
            else if(map.containsKey('n'))
            {
                 str = sb[9];       
                 i = 9;
            }                
            for(int j = 0; j < str.length(); j++)
            {                
                map.put(str.charAt(j),map.get(str.charAt(j)) - 1);                
                if(map.get(str.charAt(j)) == 0)                
                    map.remove(str.charAt(j));
            }            
            arr[i]++;
        }                       
        
        for(int i = 0; i < arr.length; i++)
        {
            while(arr[i] > 0)
            {
                res.append(Integer.toString(i));
                arr[i]--;
            }                
        }
        return res.toString();
    }
    */
}
