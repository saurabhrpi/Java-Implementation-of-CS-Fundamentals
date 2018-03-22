import  java.util.Arrays;

public class PermutationChecker {
    public boolean check(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            System.out.println("The strings dont match in length.");
            return false;
        }
         
         char [] ch = s1.toCharArray();
    	 Arrays.sort(ch);
    	 s1 = new String(ch);
    	 System.out.println("s1 :" + s1);
    	 
    	 ch = s2.toCharArray();
    	 Arrays.sort(ch);
    	 s2 = new String(ch);
    	 System.out.println("s2 :" + s2);
    	 
    	for(int i=0; i < s1.length(); i++)
    	{
    	    if(s1.charAt(i) != s2.charAt(i))
    	    {
    	        return false;
    	    }
    	}
    	
    	return true;
    }
    public static void main(String args[]) 
    {
        String s1 = "abrakadabrc";
        String s2 = "dabrakaabra";
        PermutationChecker pc = new PermutationChecker();
        if(!pc.check(s1,s2))
        {
            System.out.println("The strings are not a permutation of each other.");
        }
        else
        {
            System.out.println("The strings are indeed a permutation of each other.");
        }
    }
}
