public class Permuation_GivenSol {
    public boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        
        int[] chars = new int[128]; // Assuming it's ASCII
        char c;
        for(int i = 0; i < s1.length();i++){
            c = s1.charAt(i);
            chars[c]++;
        }
        
        for(int i = 0; i < s2.length();i++){
            c = s2.charAt(i);
            chars[c]--;
            if(chars[c]<0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        String s1 = "bacdkol";
        String s2 = "Bacdkol";
        if((s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0))
        {
            Permuation_GivenSol p = new Permuation_GivenSol();
            if(p.isPermutation(s1,s2)){
                System.out.println("Stringsa re a permutation of each other");
            }
            else{
                System.out.println("Stringsa re not a permutation of each other");
            }
        }
        else
        {
            System.out.println("One or more of the string inputs were found to be null or empty");
        }
    }
}
 
