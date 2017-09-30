public class MyClass {
    public static void main(String args[]) {
        String s = "acigf";
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
        //System.out.println(ss);
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
    
        int j = 0;
        int i;
        String finalString = "";
        for (i = 0;i < res2.length(); i++)
        {
            if(j < res1.length())
            {
             if(res2.charAt(i) < res1.charAt(j))
             {
               //res1 = res1.substring(0,j) + res2.charAt(i) + res1.substring(j);   
               finalString = finalString + res2.charAt(i) ;
             }
             else if(res2.charAt(i) > res1.charAt(j))
             {
               //res1 = res1.substring(0,j+1) + res2.charAt(i) + res1.substring(j+1);   
               finalString = finalString + res1.charAt(j) ;
               i--;
               j++;
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
        //res1 = res1.substring(0,j-1) + res2.charAt(i) + res1.charAt(j-1);
        if(j < res1.length() && i == res2.length())
        {
            finalString = finalString + res1.substring(j);
        }
        else if( i < res2.length() && j == res1.length())
        {
            finalString = finalString + res2.substring(i);
        }
        System.out.println(finalString);
        return finalString;
    }
}
