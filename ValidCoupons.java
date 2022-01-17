import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      String[] str = {"daabbd","abc","abba","abca","xaaxybbyzccz"}; //    
      List<Integer> res = findValidCoupons(str);
      for(int i : res)
      {
          System.out.println("i " + i);
      }
    }
    
    public static List<Integer> findValidCoupons(String[] strings)
    {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < strings.length; i++)
        {
            if(strings[i].length() <= 1)
            {
                res.add(1);   
            }
            else
            {
                Stack<Character> s = new Stack<Character>();
                //s.push(strings[i].charAt(0));
                for(int j = 0; j < strings[i].length();j++)
                {
                    char c =  strings[i].charAt(j);
                    if(!s.empty() && s.peek() == c)
                    {
                        s.pop();
                    }
                    else
                    {
                        s.push(c);
                    }
                }
                if(!s.empty())
                {
                    res.add(0);
                }
                else
                {
                    res.add(1);
                }
            }
        }
        return res;
    }
}
