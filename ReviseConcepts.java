import  java.util.Arrays;

public class PalindromeChecker{
    
    public boolean isPalindrome(String str)
    {
        int[] ch = new int[128]; 
        str = str.toLowerCase();
        int n = str.length();
        for(int i=0; i < n/2; i++)
        {
            if(str.charAt(i) != ' ')
            {
                ch[str.charAt(i)]++;  
                System.out.println(str.charAt(i));
                System.out.println(ch[str.charAt(i)]);
            }
        }
        
        boolean isMiddle = false;
        
        for(int i = n/2; i < n ; i++)
        {
            if(str.charAt(i) != ' ')
            {
                ch[str.charAt(i)]--;   
                System.out.println(str.charAt(i));
                System.out.println(ch[str.charAt(i)]);
                if(ch[str.charAt(i)] < 0)
                {
                    if(!isMiddle)
                    {
                        isMiddle = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;   
    }
    
    public static void main(String[] args)
    {
        String input = "cocoa";
        PalindromeChecker pc = new PalindromeChecker();
        if(pc.isPalindrome(input))
        {
            System.out.println("It's indeed a palindrome");
        }
        else
        {
            System.out.println("It's not at all a palindrome");
        }
    }
        
}

