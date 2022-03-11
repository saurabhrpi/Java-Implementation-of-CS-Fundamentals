// Leetcode problem #937
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>()
         {
             @Override
             public int compare(String s1, String s2)
             {
                 int spaceInd = s1.indexOf(' ');
                 String sub1 =  s1.substring(spaceInd + 1);                 
                 spaceInd = s2.indexOf(' ');
                 String sub2 = s2.substring(spaceInd + 1);                 
                 if(sub1.charAt(0) >= '0' && sub1.charAt(0) <= '9')
                 {
                     if(sub2.charAt(0) >= '0' && sub2.charAt(0) <= '9')
                     {                        
                        return 0;   
                     }                         
                     else
                     {                        
                         return 1;
                     }                         
                 }
                 else
                 {
                     if(sub2.charAt(0) >= '0' && sub2.charAt(0) <= '9')
                     {                        
                        return -1;
                     }                         
                     else 
                     {
                        if(sub1.compareTo(sub2) == 0)
                            return s1.compareTo(s2);
                         return sub1.compareTo(sub2);
                     }
                 }                 
             }
         });
         return logs;
    }
}
