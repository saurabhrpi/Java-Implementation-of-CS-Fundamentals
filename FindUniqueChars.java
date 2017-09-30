public class MyClass {
    public static void main(String args[]) {
        String s = "saccbe";
        String res = findUniqueCharacters(s);
        if(res == null){
            System.out.println("Null or empty string found");
        }
        if(res == "-1"){
            System.out.println("Not a unique string");
        }
        System.out.println(res);
    }
    static String findUniqueCharacters(String s){
        if(s == null || s.isEmpty()){
            return null;
        }
        String ss = mergeSort(s);
        System.out.println(ss);
        if(ss == "-1"){
            return "-1";
        }
        return ss;
    }
    static String mergeSort(String s){
        if(s.length() == 1){
          //System.out.println(s.charAt(0));     
          return String.valueOf(s.charAt(0));   
        }
        int bp = 0;
        if(s.length()%2 == 1){
            bp = (s.length()+1)/2;
            //System.out.println(bp);
        }
        else{
            bp = s.length()/2;
        }
        String b1 = s.substring(0,bp);
        //System.out.println(b1);
        String b2 = s.substring(bp);
        System.out.println(b2);
        String res1 = mergeSort(b1);
        String res2 =  mergeSort(b2);
        if(res1 == "-1" || res2 == "-1")
        {
            return "-1";
        }
        
        int min = 0;
        String big = null;
        if(res1.length() <= res2.length())
        {
            min = res1.length();
            big = res2;
        }
        else
        {
            min = res2.length();
            big = res1;
        }
        
        int j = 0;
        int i;
        for (i = 0;i < res2.length(); i++)
        {
            if(j < res1.length()-1)
            {
             if(res2.charAt(j) < res1.charAt(i))
             {
               res1 = res1.substring(0,j) + res2.charAt(i) + res1.substring(j);   
               j++;
             }
             else if(res2.charAt(i) > res1.charAt(i))
             {
               res1 = res1.substring(0,j+1) + res2.charAt(i) + res1.substring(j+1);   
               j=j+2;
             }
             else
             {
                return "-1";
             }
            }
            else
            {
                break;
            }
        }
        //System.out.println(finString);
        if(res1.charAt(j-1) > res2.charAt(i-1))
        {
            res1 = res1.substring(0,j-1) + res2.charAt(i) + res1.charAt(j-1);
        }
        res1 = res1 + res2.substring(i);
        return res1;
    }
}

