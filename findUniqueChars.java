public class MyClass{
    public static void main(String[] args){
        String s = "pseudopodia";
        findUniqueChars f = new findUniqueChars();
        if(f.isUnique(s)){
            System.out.println("It's unique");
        }
        else
        {
            System.out.println("It's not unique");           
        }
    }
}

// assuming the input character string is ASCII
class findUniqueChars{
    boolean isUnique(String s){
        if(s.length() > 128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < s.length(); i++)
        {
            int val = s.charAt(i); //implicit conversion
            System.out.println(val);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
 
