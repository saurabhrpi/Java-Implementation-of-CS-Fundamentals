// Leetcode problem #937
class Solution {
    public String[] reorderLogFiles(String[] logs) {
     Comparator comp = new Comparator<String>(){
         @Override
         public int compare(String s1, String s2)
         {
            String[] spl1 = s1.split(" ",2);
            String[] spl2 = s2.split(" ",2);            
            boolean isDigit1 = Character.isDigit(spl1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(spl2[1].charAt(0)); 
            if(!isDigit1 && !isDigit2)
            {
                int x = spl1[1].compareTo(spl2[1]);
                if(x == 0)
                    return (spl1[0]).compareTo((spl2[0]));
                return x;
            }                
            else if(!isDigit1)
            {
                return -1;
            }
            else if(!isDigit2)
            {
                return 1;
            }            
            return 0;                            
         }
     };     
     
     Arrays.sort(logs, comp);
     return logs;   
   }
}
