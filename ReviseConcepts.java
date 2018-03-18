public class PermutationChecker {
    public boolean check(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            System.out.println("The strings dont match in length.");
            return false;
        }
        
    	 HeapSort hs = new HeapSort();
    	 s1 = hs.sort(s1);
    	 s2 = hs.sort(s2);  
    	 
    	 System.out.println("s1 :" + s1);
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
        String s1 = "abrakadabra";
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

class HeapSort{
 public String sort(String str)
    {
        if(str == null || str.length() == 0)
        {
            return "Invalid String";
        }
        char[] ch = str.toCharArray();	
        int n = ch.length;
        for(int i = n/2 - 1; i >= 0; i--)
        {
            heapify(ch, i);    
        }
        String ret = new String(ch);
        return ret;
    }
 public void heapify(char[] ch, int i) 	
    {
    	int largest = i;
    	int left = 2*i + 1;
    	int right = 2*i + 2;
    	if(left < ch.length && ch[i] < ch[left])
    	{
    		largest = left;
    	}
    	 
    	if(right < ch.length && ch[largest] < ch[right])
    	{
    		largest = right;
    	}
    	 
    	if(largest != i)
    	{
    		char swap = ch[largest];
    		ch[largest] = ch[i];
    		ch[i] = swap;
    		heapify(ch, largest);
    	}
    }	
}
