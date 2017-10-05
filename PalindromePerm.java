public class PalindromePerm {
    public static void main(String args[]) {
        PalindromePerm p = new PalindromePerm();
        String s = "Tact t";
        if(p.hasPalindrome(s)){
            System.out.println("Given string has one or more palindromes in its permutation");
        }
        else{
               System.out.println("Given string doesnt have any palindromes in its permutation");
        }
    }
    public boolean hasPalindrome(String s){
        s = s.toLowerCase();
        int n = s.length();
        int[] count = new int[128];
        for(int i=0; i<n; i++)
        {
            if(Character.isLetter(s.charAt(i))){
             count[s.charAt(i)]++;   
            }
        }
        int nmid = 0;
        for(int i=0; i < count.length; i++){
            if((count[i])%2 != 0){
                 nmid++;   
            }
            if(nmid>1){
                return false;
            }
        }
        return true;
    }
}
 
