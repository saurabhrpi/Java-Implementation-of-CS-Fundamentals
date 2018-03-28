public class rotateString {
    //given method isSubstring(string s1, string s2)
    public boolean isRotation(String s1, String s2)
    {
        String s1s1 = s1 + s1;
        if(isSubstring(s1s1,s2))
        {
            return true;
        }
        return false;
    }
    
    public boolean isSubstring(String s1, String s2)
    {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if(!s1.contains(s2))
        {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        String s1 = "ttlewaterbo";
        String s2 = "terbottlewa";
        
        rotateString rs = new rotateString();
        
        if(rs.isRotation(s1,s2))
        {
            System.out.println("One of the strings is a rotation of the other ");        
        }
        else
        {
            System.out.println("One of the strings is NOT a rotation of the other ");            
        }
    }
    
}
