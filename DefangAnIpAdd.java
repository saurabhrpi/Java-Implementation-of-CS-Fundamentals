class DefangAnIpAdd {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        
        for(char c : address.toCharArray())
        {
            if(c == '.')
            {
              // Surprisingly is way faster than the alternative sol below.
              // This shouldn't be as we're doing string concatenation here.
              String s = Character.toString('[') + 
                         Character.toString('.') +
                         Character.toString(']');
              sb.append(s);                            
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// ******* Alternative solution *****//

class Solution {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        
        for(char c : address.toCharArray())
        {
            if(c == '.')
            {
              String s = Character.toString('[') ;
              sb.append(s);              
              sb.append(c);
              s = Character.toString(']') ;  
              sb.append(s);  
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
