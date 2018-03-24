public class EditDiffChecker{
    
    public boolean diffChecker(String str1, String str2)
    {
        if(Math.abs(str1.length() - str2.length()) > 1)
        {
            return false;
        }
        
        int[] ch = new int[128];
    
        for(int i=0; i < str1.length(); i++)
        {
            ch[str1.charAt(i)]++;
            System.out.println(str1.charAt(i));
            System.out.println(ch[str1.charAt(i)]);
        }
        
        for(int i=0; i < str2.length(); i++)
        {
            ch[str2.charAt(i)]--;
            System.out.println(str2.charAt(i));
            System.out.println(ch[str2.charAt(i)]);
        }
        
        System.out.println("Checking count diff");
        
        int missingChars = 0;
        for(int i=0; i < ch.length ; i++)
        {
            if(ch[i] != 0)
            {
                System.out.println((char)i);
                System.out.println(ch[i]);
                if(missingChars > 1)
                {
                    return false;
                }
                missingChars++;   
            }
        }
        
        return true;   
    }
    
    public static void main(String[] args)
    {
        String input1 = "pale";
        String input2 = "bae";
        EditDiffChecker e = new EditDiffChecker();
        
        if(e.diffChecker(input1,input2))
        {
            System.out.println("The strings differ by exactly one edit");
        }
        else
        {
            System.out.println("The strings do NOT differ by exactly one edit");
        }
    }
}
