class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // My practice of given solution. Runs in N*k where N is the length of strs and k is the avg
        // char length of each element of strs.
        // One of the biggest concept of this approach is to be able to use values of char[] to store int while using char to determine an index and then
        // convert char[] into a string.
        if(strs.length == 0)
        {
            String[] s = {""};            
            List<String> l = Arrays.asList(s);
            List<List<String>> r = new ArrayList<List<String>>();
            r.add(l);
            return r;
        }
        
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> anagrams = new HashMap<>();
        
        for(String s : strs)
        {
            char[] freqCounter = new char[26];
            //char[] ch = s.toCharArray();
            for(int i = 0; i < s.length(); i++)
            {
                freqCounter[s.charAt(i) - 'a']++;
            }
            String newS = new String(freqCounter);
            System.out.println(newS);
            if(!anagrams.containsKey(newS))
                anagrams.put(newS,new ArrayList<>());
            anagrams.get(newS).add(s);
        }        
        return new ArrayList<>(anagrams.values());
        
        // ******************** My impl. ********************
        // N*k*log(k) where N is the strs length and k is the avg length of each strs string.
        /*
        if(strs.length == 0)
        {
            String[] s = {""};            
            List<String> l = Arrays.asList(s);
            List<List<String>> r = new ArrayList<List<String>>();
            r.add(l);
            return r;
        }        
        
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> anagrams = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> ls = new ArrayList<>();                
            if(anagrams.containsKey(key))
            {                
                ls = anagrams.get(key);                    
            }
            ls.add(strs[i]);            
            anagrams.put(key,ls);
        }
        
        for(Map.Entry<String,List<String>> e : anagrams.entrySet())
        {            
            result.add(e.getValue());
        }
        return result;
        */
    }    
}
