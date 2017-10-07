public class EditDiff{
    public boolean editDiff(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1){
            return false;
        }
        int[] char_set = new int[128];// assuming ASCII
        
        for(int j=0; j < s1.length(); j++){
            char_set[s1.charAt(j)]++;
        }

        boolean thresh = false;
        for(int j = 0; j < s2.length(); j++){
            char_set[s2.charAt(j)]--;
            if(char_set[s2.charAt(j)] < 0){
                if(thresh){
                 return false;
                }
                    thresh = true;
            }
        }
        if(thresh && s1.length() > s2.length()){
            return false;   
        }
        return true;
    }
    
    public static void main(String args[]) {
        // assuming the inputs will be of same case
        String s1 = "pale";
        String s2 = "bae";
        EditDiff e = new EditDiff();
        if(e.editDiff(s1,s2)){
            System.out.println("Given strings differ by one difference at max");
        }
        else{
            System.out.println("Given strings differ by more than the allowed difference");
        }
    }
}
 
